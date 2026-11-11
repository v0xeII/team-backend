package ru.nto.team

import org.springframework.stereotype.Service

@Service
class StaffService {
    fun profile(code: String): ProfileDto = throw ApiException(501, "Task not implemented")
}
