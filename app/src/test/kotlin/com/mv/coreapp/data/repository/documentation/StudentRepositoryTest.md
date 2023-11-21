# StudentRepositoryTest Documentation

## Description
This test class is responsible for testing the functionalities of the `StudentRepositoryImpl` class. 
The test uses a fake implementation of the `StudentRemoteDataSource` interface to simulate the behavior of the remote data source.

## Setup
```kotlin
private val studentRemoteDataSource = FakeStudentRemoteDataSource()
private lateinit var studentRepository: StudentRepositoryImpl
@Before
fun setUp() {
    studentRepository = StudentRepositoryImpl(studentRemoteDataSource)
}
```

## Test Methods
This test a case when the new student is save successfully.
The test asserts that the `saveStudent` function returns `true` and that the `studentRemoteDataSource` is called with the correct parameters.
```kotlin
@Test
fun `saveStudent should return true when student is saved successfully`()
```
This test a case when the new student is not save successfully because some exception.
The test asserts that the `saveStudent` function returns `false` and that the `studentRemoteDataSource` is called with the correct parameters.
```kotlin
@Test
fun `saveStudent should return false when student is not saved successfully`()
```
This test a case when the student is found successfully.
The test asserts that the `getStudentByIdAsFlow` function returns a `Student` object and that the `studentRemoteDataSource` is called with the correct parameters.
```kotlin
@Test
fun `getStudentByIdAsFlow should return a Student if no error happen`()
```
This test a case when the student is not found because some exception.
The test asserts that the `getStudentByIdAsFlow` function returns a `Error` object and that the `studentRemoteDataSource` is called with the correct parameters.
```kotlin
@Test
fun `getStudentByIdAsFlow should return a Error Result if some error happen`()
```


