package com.dardev.Configuration

import kotlinx.serialization.KSerializer
import kotlinx.serialization.descriptors.PrimitiveKind
import kotlinx.serialization.descriptors.PrimitiveSerialDescriptor
import kotlinx.serialization.descriptors.SerialDescriptor
import kotlinx.serialization.encoding.Decoder
import kotlinx.serialization.encoding.Encoder
import kotlinx.serialization.json.JsonDecoder
import kotlinx.serialization.json.JsonEncoder
import kotlinx.serialization.json.JsonObject

object JsonObjectSerializer : KSerializer<JsonObject> {
    override val descriptor: SerialDescriptor = PrimitiveSerialDescriptor("JsonObject", PrimitiveKind.STRING)

    override fun deserialize(decoder: Decoder): JsonObject {
        val input = decoder as JsonDecoder
        return input.decodeJsonElement() as JsonObject
    }

    override fun serialize(encoder: Encoder, value: JsonObject) {
        val output = encoder as JsonEncoder
        output.json.encodeToJsonElement(JsonObject.serializer(), value)
    }
}
