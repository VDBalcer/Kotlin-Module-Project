data class Archive<T>(val title: String, val notes: MutableList<T>){
    override fun toString(): String {
        return title
    }

    companion object {
        fun isValidTitle(title: String): Boolean {
            return title.isNotBlank()
        }
    }
}