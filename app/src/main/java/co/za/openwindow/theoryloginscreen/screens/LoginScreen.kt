package co.za.openwindow.theoryloginscreen.screens

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Checkbox
import androidx.compose.material3.CheckboxDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.em
import androidx.compose.ui.unit.sp
import co.za.openwindow.theoryloginscreen.R
import co.za.openwindow.theoryloginscreen.ui.theme.Dark
import co.za.openwindow.theoryloginscreen.ui.theme.Purple
import co.za.openwindow.theoryloginscreen.ui.theme.White
import co.za.openwindow.theoryloginscreen.ui.theme.Yellow
import co.za.openwindow.theoryloginscreen.ui.theme.bebasNeueFontFamily
import org.intellij.lang.annotations.JdkConstants.HorizontalAlignment


@Composable
fun LoginScreen(
    modifier: Modifier = Modifier
) {
    val backgroundImage = painterResource(R.drawable.mobile_app_background)
    val logoImage = painterResource(R.drawable.rocketicon)
    var emailText by remember { mutableStateOf("") }
    var passwordText by remember { mutableStateOf("") }
    val rememberMeState = remember { mutableStateOf(false) }

    Box(modifier = modifier.fillMaxSize(),
    ) {

        Image(
            painter = backgroundImage,
            contentDescription = null,
            modifier = Modifier
                .fillMaxWidth()
                .height(185.dp)
        )

        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Top,
            modifier = Modifier
                .fillMaxSize()
                .padding(top = 150.dp)
                .background(Dark, shape = RoundedCornerShape(topStart = 30.dp, topEnd = 30.dp))
        ) {

            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Top,
                modifier = Modifier.padding(horizontal = 35.dp).offset(y=-55.dp)
            ) {
                Box(
                    modifier = Modifier
                        .size(115.dp)
                        .background(Yellow, shape = CircleShape)
                        .border(2.dp, Yellow, CircleShape),
                    contentAlignment = Alignment.Center
                ) {
                    Image(
                        painter = logoImage,
                        contentDescription = "Logo",
                        modifier = Modifier.size(80.dp)
                    )
                }

                Spacer(modifier = Modifier.height(50.dp))

                Text(
                    "LOGIN",
                    fontSize = 56.sp,
                    fontWeight = FontWeight.SemiBold,
                    color = Color.White,
                    lineHeight = 40.sp,
                    fontFamily = bebasNeueFontFamily,
                    letterSpacing = 0.07.em
                )

                Text(
                    "Explore the galaxy",
                    fontSize = 20.sp,
                    fontWeight = FontWeight.SemiBold,
                    color = Color.White,
                    lineHeight = 40.sp,
                    modifier = Modifier.padding(5.dp)
                )

                Column() {

                    Text(
                        "Your email",
                        fontSize = 16.sp,
                        fontWeight = FontWeight.Normal,
                        color = Color.White,
                        lineHeight = 40.sp,
                        modifier = Modifier.padding(15.dp)
                    )


                    TextField(
                        value = emailText,
                        onValueChange = { emailText = it },
                        label = { Text("Email", color = Color.White) },
                        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email),
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(50.dp)
                            .border(2.dp, Color.White, shape = RoundedCornerShape(50.dp)),
                        shape = RoundedCornerShape(50.dp),
                        colors = TextFieldDefaults.colors(
                            focusedIndicatorColor = Color.Transparent,
                            unfocusedIndicatorColor = Color.Transparent,
                            unfocusedContainerColor = Dark,
                            focusedContainerColor = Dark,
                        ),
                        singleLine = true,
                    )
                }



                Spacer(modifier = Modifier.height(10.dp))

                Column() {

                    Text(
                        "Your password",
                        fontSize = 16.sp,
                        fontWeight = FontWeight.Normal,
                        color = Color.White,
                        lineHeight = 40.sp,
                        modifier = Modifier.padding(15.dp)
                    )

                    TextField(
                        value = passwordText,
                        onValueChange = { passwordText = it },
                        label = { Text("Password", color = Color.White) },
                        visualTransformation = PasswordVisualTransformation(),
                        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(50.dp)
                            .border(2.dp, Color.White, shape = RoundedCornerShape(50.dp)),
                        shape = RoundedCornerShape(50.dp),
                        colors = TextFieldDefaults.colors(
                            focusedIndicatorColor = Color.Transparent,
                            unfocusedIndicatorColor = Color.Transparent,
                            unfocusedContainerColor = Dark,
                            focusedContainerColor = Dark,
                        ),
                        singleLine = true,
                    )
                }

                Row(
                    modifier = Modifier
                        .fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Row(verticalAlignment = Alignment.CenterVertically) {
                        Checkbox(
                            checked = rememberMeState.value,
                            onCheckedChange = { rememberMeState.value = it },
                            colors = CheckboxDefaults.colors(
                                checkedColor = Color.White,
                                uncheckedColor = Color.White,
                                checkmarkColor = Dark
                            )
                        )
                        Text(
                            "Remember me",
                            color = Color.White,
                        )
                    }

                    TextButton(
                        onClick = { /* TODO: Implement Forgot Password action */ },
                        modifier = Modifier,
                        colors = ButtonDefaults.textButtonColors(contentColor = Yellow)
                    ) {
                        Text("Forgot Password?")
                    }
                }

                Spacer(modifier = Modifier.height(20.dp))

                Button(
                    onClick = { /* Handle login */ },
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(50.dp),
                    colors = ButtonDefaults.buttonColors(
                        containerColor = Purple
                    ),
                    shape = RoundedCornerShape(50.dp)
                ) {
                    Text(
                        "Login",
                        fontSize = 18.sp,
                        color = White
                    )
                }

                Spacer(modifier = Modifier.weight(1f))

                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.Center,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(
                        "Already have an account?",
                        color = White,
                        fontWeight = FontWeight.Normal,
                        fontSize = 16.sp
                    )
                    TextButton(onClick = { /* Handle sign up */ }) {
                        Text("Sign up", color = Yellow, fontSize = 16.sp, fontWeight = FontWeight.Bold)
                    }
                }
            }


        }
    }
}



@Preview(showBackground = true)
@Composable
fun LoginScreenPreview() {
    LoginScreen()
}