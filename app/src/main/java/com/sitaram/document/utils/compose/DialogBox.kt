package com.sitaram.document.utils.compose

import android.annotation.SuppressLint
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.CornerBasedShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.Info
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.IconButton
import androidx.compose.material3.ShapeDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Dialog
import androidx.compose.ui.window.DialogProperties
import com.sitaram.document.R
import com.sitaram.document.utils.theme.black
import com.sitaram.document.utils.theme.darkGray
import com.sitaram.document.utils.theme.primary
import com.sitaram.document.utils.theme.red
import com.sitaram.document.utils.theme.textColor
import com.sitaram.document.utils.urls.CommonUrl

@Composable
fun SuccessMessageDialogBox(
    title: String? = null,
    descriptions: String? = null,
    onDismiss: () -> Unit,
    btnText: String? = null,
    color: Color? = null,
) {
    AlertDialog(
        title = {
            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Start
            ) {
                VectorIconView(
                    imageVector = Icons.Default.Info,
                    tint = color ?: primary,
                    modifier = Modifier.size(25.dp)
                )
                TextView(
                    text = title ?: "Success",
                    textType = TextType.TITLE3,
                    textAlign = TextAlign.Start,
                    color = black,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(start = 4.dp)
                )
            }
        },
        shape = ShapeDefaults.Small,
        onDismissRequest = { onDismiss() },
        text = {
            TextView(
                text = descriptions ?: stringResource(R.string.successful),
                textAlign = TextAlign.Start,
                textType = TextType.LARGE_TEXT_REGULAR,
                modifier = Modifier.fillMaxWidth()
            )
        },
        confirmButton = {
            ButtonView(
                onClick = { onDismiss() },
                colors = ButtonDefaults.buttonColors(primary),
                btnText = btnText ?: stringResource(R.string.okay),
                buttonSize = ButtonSize.LARGE,
                modifier = Modifier.wrapContentWidth()
            )
        },
        modifier = Modifier.fillMaxWidth(),
    )
}

@Composable
fun ErrorMessageDialogBox(
    title: String? = null,
    descriptions: String? = null,
    onDismiss: () -> Unit,
    btnText: String? = null,
    color: Color = Color.Transparent,
) {
    AlertDialog(
        title = {
            TextView(
                text = title.toString(),
                textType = TextType.TITLE3,
                color = color,
                textAlign = TextAlign.Start,
                modifier = Modifier.fillMaxWidth()
            )
        },
        onDismissRequest = { onDismiss() },
        text = {
            TextView(
                text = descriptions ?: "",
                textAlign = TextAlign.Start,
                textType = TextType.LARGE_TEXT_REGULAR,
                modifier = Modifier.fillMaxWidth()
            )
        },
        confirmButton = {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = 5.dp),
                horizontalArrangement = Arrangement.Center
            ) {
                DangerButtonView(
                    onClick = { onDismiss() },
                    colors = ButtonDefaults.buttonColors(color),
                    btnText = btnText ?: "",
                    modifier = Modifier.fillMaxWidth(),
                )
            }
        },
        modifier = Modifier.fillMaxWidth(),
    )
}

@Composable
fun ConfirmationDialogView(
    title: String,
    descriptions: String,
    cancelBtnText: String? = null,
    confirmBtnText: String? = null,
    onDismiss: (() -> Unit)? = null,
    onConfirm: (() -> Unit)? = null,
    btnColor: Color? = red,
) {
    AlertDialog(
        title = {
            TextView(
                text = title,
                textType = TextType.TITLE3,
                textAlign = TextAlign.Start,
                color = textColor,
            )
        },
        text = {
            TextView(
                text = descriptions,
                color = textColor,
                textAlign = TextAlign.Start,
                textType = TextType.LARGE_TEXT_REGULAR,
            )
        },
        confirmButton = {
            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceAround
            ) {
                OutlineButtonView(
                    onClick = { onDismiss?.invoke() },
                    btnText = cancelBtnText ?: stringResource(R.string.cancel),
                    buttonSize = ButtonSize.MEDIUM,
                    modifier = Modifier
                        .border(1.dp, color = primary, shape = CircleShape)
                        .height(40.dp)
                        .weight(0.4f),
                )
                Spacer(modifier = Modifier.padding(horizontal = 4.dp))
                ButtonView(
                    onClick = { onConfirm?.invoke() },
                    btnText = confirmBtnText ?: stringResource(R.string.confirm),
                    buttonSize = ButtonSize.MEDIUM,
                    colors = ButtonDefaults.buttonColors(btnColor ?: red),
                    modifier = Modifier
                        .weight(0.4f),
                )
            }
        },
        onDismissRequest = { onDismiss?.invoke() },
        modifier = Modifier.fillMaxWidth(),
        shape = CardDefaults.elevatedShape
    )
}


// Information
@Composable
fun InformationMessageDialogBox(
    title: String? = null,
    descriptions: String? = null,
    onDismiss: () -> Unit,
    btnText: String? = null,
    color: Color? = null,
    imageVector: ImageVector = Icons.Default.Info,
) {
    AlertDialog(
        title = {
            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Start
            ) {
                VectorIconView(
                    imageVector = imageVector,
                    tint = color ?: primary,
                    modifier = Modifier.size(25.dp)
                )
                TextView(
                    text = title ?: stringResource(R.string.info),
                    textType = TextType.TITLE3,
                    textAlign = TextAlign.Start,
                    color = black,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(start = 4.dp)
                )
            }
        },
        shape = ShapeDefaults.Small,
        onDismissRequest = { onDismiss() },
        text = {
            TextView(
                text = descriptions ?: stringResource(R.string.successful),
                textAlign = TextAlign.Start,
                textType = TextType.LARGE_TEXT_REGULAR,
                modifier = Modifier.fillMaxWidth()
            )
        },
        confirmButton = {
            ButtonView(
                onClick = { onDismiss() },
                colors = ButtonDefaults.buttonColors(primary),
                btnText = btnText ?: stringResource(id = R.string.okay),
                buttonSize = ButtonSize.LARGE,
                modifier = Modifier.wrapContentWidth()
            )
        },
        modifier = Modifier.fillMaxWidth(),
    )
}

// input dialog box
@Composable
fun InputDialogBoxView(
    title: String? = null,
    body: @Composable () -> Unit,
    onDismissRequest: (() -> Unit)? = null,
    confirmButton: (() -> Unit)? = null,
    @SuppressLint("ModifierParameter")
    modifier: Modifier = Modifier,
    dismissButton: @Composable (() -> Unit)? = null,
    icon: @Composable (() -> Unit)? = null,
    shape: CornerBasedShape = ShapeDefaults.Medium,
    containerColor: Color = Color.White,
    iconContentColor: Color = Color.Unspecified,
    titleContentColor: Color = Color.Unspecified,
    textContentColor: Color = Color.Unspecified,
    tonalElevation: Dp = 0.dp,
    vectorIcon: ImageVector? = null,
    tint: Color = darkGray,
    enabled: Boolean? = true,
    properties: DialogProperties = DialogProperties(),
) {
    AlertDialog(
        title = {
            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Start
            ) {
                if (vectorIcon != null) {
                    VectorIconView(
                        imageVector = vectorIcon,
                        tint = tint,
                        modifier = Modifier.size(25.dp)
                    )
                }
                TextView(
                    text = title ?: "Information",
                    textType = TextType.TITLE3,
                    textAlign = TextAlign.Start,
                    color = darkGray,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(start = 4.dp)
                )
            }
        },
        text = {
            body()
        },
        onDismissRequest = {
            onDismissRequest?.invoke()
        },
        confirmButton = {
            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                OutlineButtonView(
                    onClick = {
                        onDismissRequest?.invoke()
                    },
                    btnText = "Cancel",
                    modifier = Modifier
                        .weight(1f)
                        .border(1.dp, color = primary, shape = CircleShape)
                        .height(40.dp),
                    buttonSize = ButtonSize.MEDIUM
                )
                Spacer(modifier = Modifier.padding(4.dp))
                ButtonView(
                    onClick = {
                        confirmButton?.invoke()
                    },
                    btnText = "Update",
                    modifier = Modifier
                        .weight(1f),
                    buttonSize = ButtonSize.MEDIUM,
                    enabled = enabled ?: true,
                )
            }
        },
        dismissButton = dismissButton,
        icon = icon,
        shape = shape,
        containerColor = containerColor,
        iconContentColor = iconContentColor,
        titleContentColor = titleContentColor,
        textContentColor = textContentColor,
        tonalElevation = tonalElevation,
        properties = properties,
        modifier = modifier
    )
}

// View Image
@Composable
fun ImageDialogView(
    streamUrl: String? = null,
    onDismiss: () -> Unit,
) {
    Dialog(
        onDismissRequest = { onDismiss.invoke() },
        properties = DialogProperties(dismissOnBackPress = false, dismissOnClickOutside = true)
    ) {
        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.End
            ) {
                IconButton(onClick = { onDismiss.invoke() }) {
                    VectorIconView(
                        imageVector = Icons.Default.Close,
                        tint = primary
                    )
                }
            }
            AsyncImageView(
                model = streamUrl ?: CommonUrl.FOOD_URL,
                modifier = Modifier
                    .height(200.dp)
                    .fillMaxWidth(),
                contentScale = ContentScale.Crop
            )

        }
    }
}