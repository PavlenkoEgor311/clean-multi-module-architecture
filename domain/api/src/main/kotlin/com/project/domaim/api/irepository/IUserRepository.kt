package com.project.domaim.api.irepository

interface IUserRepository {

    fun getToken(): String
    fun isAuthUser(): Boolean
}