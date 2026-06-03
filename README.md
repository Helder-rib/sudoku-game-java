# 🧩 Sudoku Engine - Java Console Application

Uma implementação robusta e elegante do clássico jogo Sudoku desenvolvida em Java para o terminal. O projeto foi construído focando em boas práticas de Programação Orientada a Objetos (POO), validações defensivas com Java Streams e uma arquitetura limpa com separação de responsabilidades.

---
## 📸 Interface do Tabuleiro (Console UI)

O tabuleiro é renderizado dinamicamente utilizando caracteres de desenho de caixa (Box-Drawing ASCII), garantindo a perfeita identificação dos quadrantes 3x3 tradicionais do Sudoku:

```
┌───────┬───────┬───────┐
│ . . . │ . . . │ . . 5 │
│ . . . │ . . . │ . . . │
│ . . . │ . . . │ . . . │
├───────┼───────┼───────┤
│ . . 4 │ . . . │ . . 7 │
│ . 9 . │ . . . │ . . . │
│ . . . │ . . . │ . . . │
├───────┼───────┼───────┤
│ . . . │ . . . │ . . 3 │
│ . . . │ . . . │ . . . │
│ . . . │ . 7 . │ . . . │
└───────┴───────┴───────┘
```

## 🚀 Funcionalidades

O motor do jogo conta com um menu interativo no console que oferece as seguintes opções:

1. **Iniciar um novo jogo:** Carrega o tabuleiro inicial a partir de argumentos passados na inicialização (`args`).
2. **Colocar um novo número:** Permite a inserção de jogadas, impedindo a alteração de células fixas ou já preenchidas.
3. **Remover um número:** Limpa uma jogada feita pelo usuário (protegendo as células nativas do tabuleiro).
4. **Verificar jogo:** Renderiza o tabuleiro no console com alinhamento visual por quadrantes 3x3 e barras divisórias.
5. **Verificar status do jogo:** Analisa a matriz em tempo real e retorna o estado atual por meio de polimorfismo com Enums (`NÃO INICIADO`, `INCOMPLETO`, `INCOMPLETO COM ERROS`, `COMPLETO`, `COMPLETO COM ERROS`).
6. **Limpar:** Reseta todas as jogadas do usuário, mantendo apenas os números fixos iniciais.
7. **Finalizar o jogo:** Encerra a aplicação.

---

## 🛠️ Destaques Técnicos & Aprendizados

* **Programação Funcional & Streams:** Validação complexa de linhas, colunas e quadrantes 3x3 utilizando a API de Streams do Java (`.map()`, `.distinct()`, `.filter()`).
* **Isolamento de Escopo:** Mapeamento de objetos complexos para tipos primitivos antes da verificação de duplicatas, garantindo o funcionamento correto do critério de distinção sem interferir na semântica do método `equals()`.
* **Programação Defensiva (Fail-Fast):** Tratamento rigoroso de entradas de usuário (remoção de espaços com `.trim()`, rejeição de entradas vazias com `.isBlank()`) e lançamento de exceções customizadas (`IllegalArgumentException` e `IllegalStateException`) antes do processamento lógico principal.
* **Polimorfismo com Enums:** Uso de métodos abstratos dentro do Enum `Status` para descentralizar e especializar a exibição textual de cada estado do jogo.

---

## 💻 Como Executar o Projeto

### Pré-requisitos
* Java JDK 17 ou superior instalado.

### Passos
1. Clone o repositório:
   ```bash
   git clone https://github.com/Helder-rib/sudoku-game-java.git
Navegue até o diretório do projeto:

```
cd nome-do-diretorio
```
Compile os arquivos .java.

Execute a classe Main passando os números fixos iniciais no formato linha,coluna,valor como argumentos de inicialização.

Exemplo de inicialização via terminal:

```
java com.desafio.app.Main "1,5,5" "4,3,4" "4,9,7" "5,2,9" "7,9,1" "9,5,7"
```
🧠 Estrutura de Pastas
```
src/
└── com/
    └── desafio/
        ├── app/
        │   └── Main.java            # Controle de fluxo e menu interativo
        ├── model/
        │   ├── Celula.java          # Representação de cada casa (fixed/number)
        │   ├── Tabuleiro.java       # Matriz 9x9 e regras de manipulação
        │   └── Status.java          # Enum polimórfico de estados do jogo
        └── service/
            └── SudokuService.java   # Motor de regras e validações matemáticas (Streams)
```
📝 Licença
Este projeto está sob a licença MIT. Veja o arquivo LICENSE para mais detalhes.

Feito  por Hélder
