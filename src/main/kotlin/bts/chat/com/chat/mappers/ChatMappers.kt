package bts.chat.com.chat.mappers

import bts.chat.com.auth.model.User
import bts.chat.com.auth.model.request.SignupRequest
import bts.chat.com.chat.model.Location
import bts.chat.com.chat.model.Message
import bts.chat.com.db.datastore.dao.ChatsDao
import bts.chat.com.db.datastore.dao.MessageLocation
import bts.chat.com.db.datastore.dao.UserEntity

fun Message.toChatEntity() = ChatsDao(
    messageTo = this.messageTo,
    messageFrom = this.messageFrom,
    messageText = this.messageText,
    timeStamp = this.timeStamp,
    latLng = MessageLocation(this.latLng.latitude, this.latLng.longitude),
    userName = this.userName,
    lastSeen = this.lastSeen
)

fun ChatsDao.toMessage() = Message(
    messageTo = this.messageTo,
    messageFrom = this.messageFrom,
    messageText = this.messageText,
    timeStamp = this.timeStamp,
    latLng = Location(this.latLng.latitude, this.latLng.longitude),
    userName = this.userName,
    lastSeen = this.lastSeen
)