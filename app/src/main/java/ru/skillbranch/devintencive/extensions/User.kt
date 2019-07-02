package ru.skillbranch.devintencive.extensions

import ru.skillbranch.devintencive.models.UserView
import ru.skillbranch.devintencive.models.User
import ru.skillbranch.devintencive.utils.Utils
import java.util.*


fun User.toUserView(): UserView {
    val nickName = Utils.transLiteration(firstName,lastName)
    val initial = Utils.makeInitial(firstName,lastName)
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




fun Date.humanizeDiff(date: Date = Date()): String {


    return ""
}
