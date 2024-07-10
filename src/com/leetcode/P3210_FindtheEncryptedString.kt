fun getEncryptedString(s: String, k: Int): String {
    return s.indices.map { i -> s[(i + k) % s.length] }.joinToString("")
}
