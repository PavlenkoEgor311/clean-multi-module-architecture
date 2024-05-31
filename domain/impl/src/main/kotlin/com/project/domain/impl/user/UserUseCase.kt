package com.project.domain.impl.user

import com.project.domaim.api.irepository.IUserRepository

class UserUseCase(
    private val userRepository: IUserRepository
) : IUserUseCase {
    override fun isAuth(): Boolean = userRepository.isAuthUser()
}