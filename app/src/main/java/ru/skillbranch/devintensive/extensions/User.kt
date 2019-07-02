package ru.skillbranch.devintensive.extensions

import ru.skillbranch.devintensive.models.UserView
import ru.skillbranch.devintensive.models.User
import ru.skillbranch.devintensive.utils.Utils


fun User.toUserView(): UserView {
    val nickName = Utils.transliteration(firstName,lastName)
    val initial = Utils.toInitials(firstName,lastName)
    val status = if (lastVisit == null) {
        "еще ни разу не был"
    } else if (isOnLine) {
        "online"
    } else {
        "последний раз был ${lastVisit.humanizeDiff()}"
    }

    return UserView(
        id,
        fullName = "$firstName $lastName",
        nickName = nickName,
        avatar = avatar,
        status = status
    )
}





