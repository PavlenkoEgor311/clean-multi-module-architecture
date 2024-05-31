package com.project.domaim.api.transform

interface ITransform<T> {
    fun toDomain(): T
}