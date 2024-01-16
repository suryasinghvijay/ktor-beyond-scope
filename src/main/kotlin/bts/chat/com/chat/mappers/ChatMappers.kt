package bts.chat.com.chat.mappers

import bts.chat.com.auth.model.User
import bts.chat.com.auth.model.request.SignupRequest
import bts.chat.com.chat.model.Location
import bts.chat.com.chat.model.Message
import bts.chat.com.db.datastore.dao.ChatsDao
import bts.chat.com.db.datastore.dao.MessageLocation
import bts.chat.com.db.datastore.dao.UserEntity

fun Message.toChatEntity() = ChatsDao(
    messageToUserId = this.messageToUserId,
    messageFromUserId = this.messageFromUserId,
    messageText = this.messageText,
    timeStamp = System.currentTimeMillis(),
    latLng = MessageLocation(this.latLng?.latitude, this.latLng?.longitude),
    userName = this.userName,
)

fun ChatsDao.toMessage() = Message(
    messageToUserId = this.messageToUserId,
    messageFromUserId = this.messageFromUserId,
    messageText = this.messageText,
    latLng = Location(this.latLng?.latitude, this.latLng?.longitude),
    userName = this.userName,
)