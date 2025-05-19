data class Note (val title: String, val content: String){
    override fun toString(): String {
        return title
    }

    companion object {
        fun isValidTitle(title: String): Boolean {
            return title.isNotBlank()
        }
        fun isValidContent(text: String): Boolean {
            return text.isNotBlank()
        }

    }
}