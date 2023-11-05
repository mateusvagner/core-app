package com.mv.coreapp.designsystem.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.IconButton
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.mv.coreapp.R

@Composable
fun BackButtonHeader(
    modifier: Modifier = Modifier,
    onBackPressed: () -> Unit
) {
    Row(
        modifier = modifier.padding(start = 8.dp, top = 8.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        IconButton(onClick = onBackPressed) {
            Image(
                painter = painterResource(
                    id = R.drawable.ic_arrow_back_ios_new
                ),
                contentDescription = stringResource(
                    id = R.string.back
                )
            )
        }
        Spacer(modifier = Modifier.weight(1f))
    }
}

@Composable
@Preview
fun BackButtonHeaderPreview() {
    Surface {
        BackButtonHeader(onBackPressed = {})
    }
}