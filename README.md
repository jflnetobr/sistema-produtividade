# Sistema de Gestão de Produtividade Acadêmica

Projeto da disciplina de Projeto de Software - Curso de Engenharia de Computação (UFAL)

## Como executar

Estando na raiz do projeto, basta executar o comando:

      javac src/Main.java && java src/Main

## Decisões tomadas no sistema

Alguns aspectos da modelagem não ficaram explícitos na especificação, de forma que foram tomadas as seguintes decisões durante a modelagem:

 - Sobre o laboratório
 
 1. O sistema é voltado para um laboratório apenas ou vários?

	**Como a ideia inicial não é que o sistema rode em rede nem nada do tipo, se imaginou que cada laboratório vai ter sua própria instância rodando. Portanto, o sistema foi projetado para apenas um laboratório, objetivando uma implementação e uso mais simples, mas é possível adequar para atender N laboratórios com facilidade, cada um com seu administrador. Serão informados no primeiro acesso ao sistema:**
	- **Nome do laboratório;**
	- **Instituição de que faz parte.**

- Sobre o administrador

2. Deve existir apenas um administrador por laboratório, mais de um por laboratório, ou, ainda, apenas um administrador para todo o sistema?

	**Assim como o laboratório, existirá apenas um administrador para todo o sistema, que é cadastrado no primeiro acesso junto com as informações do laboratório. Será informado no cadastro o nome do Administrador;**

- Sobre o colaborador

3. Que atributos um colaborador deve ter?

	**Para o colaborador são solicitadas as seguintes informações, de acordo com a segunda parte da especificação:**
	- **Nome;**
	- **E-mail.**

- Sobre as orientações

4. Orientações são uma classe a parte ou elas e as publicações são herdeiras da classe “Produção Acadêmica” com os atributos de publicação?

	**As classes Publicacao e Orientacao herdarão de ProducaoAcademica. Esta última terá título e ano de publicação.**

5. Quantos alunos podem ser orientados (um ou vários) e quantos professores podem participar de uma orientação (um ou vários)?

	**Considerei que um professor pode orientar um ou mais alunos em cada orientação.**

6. Se a orientação for uma entidade a parte, que atributos deve ter? Apenas orientador(es) e orientado(s)? Orientações estão relacionadas com projetos, assim como as Produções?

	**Considerei que apenas a classe Publicacao está relacionada com os projetos.**
	**Para uma orientação, além de título, ano de publicação e projeto, herdados, existirão também:**
	
	- **Orientador (colaborador do tipo professor);**
	- **Orientados (colaboradores do tipo aluno, que só podem estar em uma orientação).**
