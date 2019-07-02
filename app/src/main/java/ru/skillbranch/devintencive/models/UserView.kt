package ru.skillbranch.devintencive.models

class UserView(
    private val id: String?,
    private var fullName: String?,
    private var nickName: String?,
    private var avatar: String? =null,
    private var status: String? = "off-line",
    private var initials : String? = ""
)