package ru.skillbranch.devintensive.models

import ru.skillbranch.devintensive.extensions.humanizeDiff
import java.util.*

class ImageMessage(
    id: String,
    from: User?,
    chat: Chat,
    isIncomeng: Boolean = false,
    date: Date = Date(),
    var image: String?
) : BaseMessage(id, from, chat, isIncomeng, date) {
    override fun formatMessage(): String =
        "id: $id ${from?.firstName} ${if(isIncomeng)"receive" else "sent"} image \"$image\" ${Date().humanizeDiff()} "
}