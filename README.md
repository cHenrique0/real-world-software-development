Real World Software Development

# Chapter 02

### KISS - _Keep It Short and Simple_

Um código deve ter uma boa manuteneabilidade:
- Deve ser simples encontrar o código responsável por determinado recurso
- Deve ser simples entender o que o código faz
- Deve ser simples remover ou adicionar novo recursos
- Deve oferecer um bom _encapsulamento_

> Deve-se evitar:
> - Classe _"deus"_ (uma classe que faz tudo)
> - Duplicação de código

### SRP - _Single Responsible Principle_

Princípio da responsabilidade única, em português livre. É aplicado em metódos e classes.
- Uma classe tem responsabilidade sobre _uma única_ funcionalidade
- Só existe um motivo para a classe mudar

### Coesão
Trata-se da relação entre as coisas, ou seja, o quanto as classes e metódos estão interligados.
O **objetivo** é chegar numa _alta coesão_, pois isso garante que o código será mais fácil de ser 
encontrado, entendido e utilizado por outras pessoas.

### Acoplamento
Diz respeito ao quão dependente as coisas são. Está relacionado à dependência que uma classe tem 
de outras classes.
> **Interfaces** são as responsáveis por promover flexibilidade para requisitos que mudam

O **objetivo** é alcançar um _baixo acoplamento_, ou seja, diferentes componentes não dependem de 
detalhes internos ou implementações.

**Deve-se sempre evitar o alto acoplamento**