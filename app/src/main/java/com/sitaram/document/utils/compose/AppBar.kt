package com.sitaram.document.utils.compose

import android.annotation.SuppressLint
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Badge
import androidx.compose.material.BadgedBox
import androidx.compose.material.IconButton
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import com.sitaram.document.utils.theme.darkGray
import com.sitaram.document.utils.theme.gray
import com.sitaram.document.utils.theme.textColor
import com.sitaram.document.utils.theme.white

/**
 * Composable function that creates a customized top app bar with a title, leading and trailing icons.
 *
 * @param title The title text to display in the app bar.
 * @param color The color of the title text.
 * @param backgroundColor The background color of the app bar.
 * @param modifier The modifier for the top app bar.
 * @param leadingIcon The icon to use for the leading action.
 * @param trailingIcon The icon to use for the trailing action.
 * @param onClickLeadingIcon The action to perform when the leading icon is clicked.
 * @param onClickTrailingIcon The action to perform when the trailing icon is clicked.
 */
@Composable
fun TopAppBarView(
    title: String,
    color: Color = textColor,
    backgroundColor: Color = Color.White,
    @SuppressLint("ModifierParameter")
    modifier: Modifier = Modifier,
    leadingIcon: ImageVector? = null,
    trailingIcon: ImageVector? = null,
    onClickLeadingIcon: (() -> Unit)? = null,
    onClickTrailingIcon: (() -> Unit)? = null,
) {
    TopAppBar(
        title = {
            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.End
            ) {
                TextView(
                    text = title,
                    color = color,
                    textType = TextType.TITLE4,
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis,
                    textAlign = TextAlign.Start,
                    modifier = Modifier.weight(1f)
                )
                if (trailingIcon != null) {
                    IconButton(
                        onClick = { onClickTrailingIcon?.invoke() },
                        modifier = Modifier.wrapContentSize()
                    ) {
                        VectorIconView(
                            imageVector = trailingIcon,
                            modifier = Modifier.size(20.dp),
                            tint = color
                        )
                    }
                }
            }
        },
        backgroundColor = backgroundColor,
        navigationIcon = {
            IconButton(
                onClick = { onClickLeadingIcon?.invoke() },
                modifier = Modifier.wrapContentSize()
            ) {
                if (leadingIcon != null) {
                    VectorIconView(
                        imageVector = leadingIcon,
                        modifier = Modifier.size(20.dp),
                        tint = color
                    )
                }
            }
        },
        modifier = modifier,
    )
}

/**
 * Composable function that creates a customized top app bar with title, notification icon, and additional actions.
 *
 * @param title The title text to display in the app bar.
 * @param modifier The modifier for the top app bar.
 * @param navigationIcon The icon to use for the navigation button.
 * @param backgroundColor The background color of the app bar.
 * @param contentColor The color of the content within the app bar.
 * @param numOfNotification The number of notifications to display on the badge.
 * @param notificationIcon The icon to use for the notification button.
 * @param vectorIcon The icon to use for the additional action button.
 * @param onClickAction The action to perform when the additional action button is clicked.
 */
@Composable
fun TopAppBarIconView(
    title: String? = null,
    @SuppressLint("ModifierParameter") modifier: Modifier = Modifier,
    navigationIcon: @Composable (() -> Unit)? = null,
    backgroundColor: Color = Color.Unspecified,
    contentColor: Color = Color.Unspecified,
    numOfNotification: Int = 0,
    notificationIcon: ImageVector? = null,
    vectorIcon: ImageVector? = null,
    onClickAction: (() -> Unit)? = null,
) {
    TopAppBar(
        title = {
            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                TextView(text = title ?: "", textType = TextType.LARGE_TEXT_BOLD, color = darkGray)
                if (notificationIcon != null) {
                    BadgedBox(
                        badge = {
                            if (numOfNotification != 0) {
                                Badge {
                                    TextView(
                                        text = if (numOfNotification > 9) "+9" else numOfNotification.toString(),
                                        color = white
                                    )
                                }
                            }
                        },
                        modifier = Modifier.padding(end = 14.dp)
                    ) {
                        IconButton(
                            modifier = Modifier
                                .wrapContentSize()
                                .clip(CircleShape)
                                .background(white)
                                .size(30.dp),
                            onClick = {
                                onClickAction?.invoke()
                            }
                        ) {
                            VectorIconView(
                                imageVector = notificationIcon,
                                tint = gray,
                                modifier = Modifier.size(25.dp)
                            )
                        }
                    }
                }
                if (vectorIcon != null) {
                    IconButton(onClick = { onClickAction?.invoke() }) {
                        VectorIconView(imageVector = vectorIcon, tint = gray)
                    }
                }
            }
        },
        modifier = modifier,
        navigationIcon = navigationIcon,
        backgroundColor = backgroundColor,
        contentColor = contentColor
    )
}