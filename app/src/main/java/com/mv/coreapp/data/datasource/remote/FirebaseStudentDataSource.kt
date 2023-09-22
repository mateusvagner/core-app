package com.mv.coreapp.data.datasource.remote

import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener
import com.mv.coreapp.data.datasource.StudentDataSource
import com.mv.coreapp.data.dto.StudentDto
import kotlinx.coroutines.channels.awaitClose
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.callbackFlow
import kotlinx.coroutines.suspendCancellableCoroutine
import javax.inject.Inject
import kotlin.coroutines.resume
import kotlin.coroutines.resumeWithException

class FirebaseStudentDataSource @Inject constructor(
    firebaseDatabase: FirebaseDatabase
) : StudentDataSource {

    private val studentDatabase = firebaseDatabase.reference.child("student")

    override suspend fun saveStudent(student: StudentDto) {
        studentDatabase.child(student.id).setValue(student)
    }

    /**
     * suspendCancellableCoroutine is a low-level function in the kotlinx.coroutines library that
     * allows you to turn callback-based APIs into suspending functions, thus better integrating them
     * with the rest of your Kotlin coroutines-based code.
     */
    override suspend fun getAllStudents(): List<StudentDto> =
        suspendCancellableCoroutine { continuation ->
            studentDatabase.get().addOnSuccessListener { snapShot ->
                val students = snapShot.children.mapNotNull { it.getValue(StudentDto::class.java) }
                continuation.resume(students)
            }.addOnFailureListener { exception ->
                continuation.resumeWithException(exception)
            }

//        val listener = object : ValueEventListener {
//            override fun onDataChange(snapshot: DataSnapshot) {
//                val students = snapshot.children.mapNotNull { it.getValue(StudentDto::class.java) }
//                continuation.resume(students)
//            }
//
//            override fun onCancelled(error: DatabaseError) {
//                continuation.resumeWithException(error.toException())
//            }
//        }

//        databaseChild.addListenerForSingleValueEvent(listener)
//        continuation.invokeOnCancellation { databaseChild.removeEventListener(listener) }
        }

    /**
     * callbackFlow: This is specifically designed for callback-based APIs.
     * The trySend method used inside the callbackFlow builder isn't a suspending function and
     * can be called outside of coroutines. This kind of Flow is usually used with
     * listeners/callbacks APIs like Firebase, location updates, etc.
     */
    override suspend fun getAllStudentsAsFlow(): Flow<List<StudentDto>> = callbackFlow {
        val listener = object : ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {
                val students = snapshot.children.mapNotNull { it.getValue(StudentDto::class.java) }
                trySend(students)
            }

            override fun onCancelled(error: DatabaseError) {
                close(error.toException())
            }
        }

        studentDatabase.addListenerForSingleValueEvent(listener)
        awaitClose { studentDatabase.removeEventListener(listener) }
    }
}
