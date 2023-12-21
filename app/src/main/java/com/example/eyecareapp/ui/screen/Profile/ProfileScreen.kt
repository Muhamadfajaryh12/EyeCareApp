package com.example.eyecareapp.ui.screen.Profile

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.platform.LocalContext
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.eyecareapp.ViewModelFactory
import com.example.eyecareapp.data.preference.UserPreferences
import com.example.eyecareapp.data.preference.dataStore
import com.example.eyecareapp.ui.common.UiState
import com.example.eyecareapp.ui.components.content.ProfileContent
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.runBlocking

@Composable
fun ProfileScreen (
    navigateToChangeProfile: () -> Unit,
    viewModel: ProfileViewModel = viewModel(
        factory = ViewModelFactory.getInstance(LocalContext.current)

    ),
    navigateToLogin:()->Unit,
) {
    val context = LocalContext.current
    val pref = UserPreferences.getInstance(context.dataStore)
    val user = runBlocking { pref.getSession().first() }
    viewModel.profileState.collectAsState(initial = UiState.Loading).value.let {
        state-> when(state){
            is UiState.Loading->{
                viewModel.profile(user.id)
            }
            is UiState.Success->{
                ProfileContent(
                    navigateToChangeProfile,
                    logout = viewModel::logout,
                    navigateToLogin = navigateToLogin,
                    username = state.data?.data?.name.toString(),
                    email = state.data?.data?.email.toString()
                )
            }
            is UiState.Error->{}
        }
    }
}