enum class Nivel { BASICO, MEDIO, AVANCADO }

data class Usuario(val id: Int, val nome: String, val nivelEscolar: Nivel)

data class ConteudoEducacional(val nome: String, val duracao: Int)

data class Formacao(val idCurso: Int, val nome: String, val conteudo: List<ConteudoEducacional>) {
    val inscritos = mutableListOf<Usuario>()

    fun matricula(usuario: Usuario) {
        inscritos.add(usuario)
    }
}

fun main() {
    // Cadastrar usuários
    val usuario1 = Usuario(1, "João", Nivel.MEDIO)
    val usuario2 = Usuario(2, "Maria", Nivel.BASICO)
    val usuario3 = Usuario(3, "Carlos", Nivel.AVANCADO)

    // Cadastrar cursos
    val curso1 = Formacao(1, "Curso de Matemática", mutableListOf<ConteudoEducacional>())
    val curso2 = Formacao(2, "Curso de História", mutableListOf<ConteudoEducacional>())
    val curso3 = Formacao(3, "Curso de Kotlin", mutableListOf<ConteudoEducacional>())

    // Matricular usuários nos cursos
    curso1.matricula(usuario1)
    curso1.matricula(usuario2)
    curso2.matricula(usuario2)
    curso2.matricula(usuario3)

    // Imprimir os dados cadastrados
    println("Usuários cadastrados:\n")
    println(usuario1)
    try {
        curso1.matricula(usuario1)
        println("Cadastrado com sucesso o aluno ${usuario1.nome}!!\n")
    }catch (e: Exception){
        println("Nao foi possivel cadastrar\n")
    }
    println(usuario2)
    try {
        curso1.matricula(usuario2)
        println("Cadastrado com sucesso o aluno ${usuario2.nome} !!\n")
    }catch (e: Exception){
        println("Nao foi possivel cadastrar\n")
    }
    println(usuario3)
    try {
		 curso2.matricula(usuario3)
        println("Cadastrado com sucesso o aluno ${usuario3.nome} !!")
    }catch (e: Exception){
        println("Nao foi possivel cadastrar\n")
    }
   

	println(" ")
    println("Cursos cadastrados:\n")
    println(curso1)
    println(curso2)
    println(curso3)
    
     // Contagem de alunos cadastrados
    val totalAlunosCadastrados = curso1.inscritos.size
    println("\nTotal de alunos cadastrados: $totalAlunosCadastrados com sucesso !!")
}
