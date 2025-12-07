## AT

### Contextualização
Você acaba de integrar a equipe técnica de uma empresa de logística responsável por um sistema legado que apresenta dificuldades recorrentes de manutenção, inconsistência nas regras de negócio e baixa clareza estrutural. O módulo responsável pela criação e gerenciamento de pedidos de entrega está especialmente problemático, com código de difícil compreensão, regras duplicadas, responsabilidades misturadas e ausência de validações.

Sua tarefa será conduzir uma refatoração progressiva deste módulo, aplicando os princípios de Clean Code e Engenharia de Software discutidos em aula, com foco em clareza, modularidade, robustez e reaproveitamento de código.

Código Legado:

```java
public class Pedido {
    public String endereco;
    public double peso;
    public String tipoFrete;
    public String destinatario;

    public double calcularFrete() {
        if (tipoFrete.equals("EXP")) {
            return peso * 1.5 + 10;
        } else if (tipoFrete.equals("PAD")) {
            return peso * 1.2;
        } else if (tipoFrete.equals("ECO")) {
            return peso * 1.1 - 5;
        } else {
            return 0;
        }
    }

    public String gerarEtiqueta() {
        return "Destinatário: " + destinatario + "\nEndereço: " + endereco + "\nValor do Frete: R$" + calcularFrete();
    }

    public String gerarResumoPedido() {
        return "Pedido para " + destinatario + " com frete tipo " + tipoFrete + " no valor de R$" + calcularFrete();
    }

    public void aplicarFretePromocional() {
        if (peso > 10) {
            peso = peso - 1;
        }
    }

    public boolean isFreteGratis() {
        return tipoFrete.equals("ECO") && peso < 2;
    }
}
```

### Atividades de Desenvolvimento
1. PROBLEMAS IDENTIFICADOS

Ausência de Encapsulamento (Violação do Princípio da Ocultaão):
- Problema: Todos os atributos da classe Pedido são públicos (public), permitindo acesso e modificação direta sem controle.
- Impacto: há a Impossibilidade de garantir invariantes da classe, além de gerar dificuldade de rastrear alterações e depurar erros.

Acoplamento Alto entre Lógica de Negócio e Apresentação
- Problema: A classe Pedido mistura responsabilidades de Cálculo de frete (lógica de negócio), de geração de strings formatadas (apresentação) e aplicação de regras promocionais.
- Impacto: Violação do princípio de responsabilidade única (SRP).

Uso de Valores Mágicos (Magic Numbers):
- Problema: Valores literais dispersos no código:

```java
peso * 1.5 + 10      // O que é 1.5? O que é 10?
peso * 1.2           // O que é 1.2?
peso * 1.1 - 5       // O que é 1.1 e 5?
```

- Impacto: Pode gerar dificuldade de compreensão do código, aumenta o risco de erros ao modificar valores além de impossibilitar a centralização de configurações.

Falta de Validações e Tratamento de Erros:
- Problema: Não há nenhuma validação de entrada nos construtores/métodos, além de possuir tratamento silencioso de erros (retorna 0 para tipo de frete inválido) e permite estados inconsistentes (peso negativo, tipo de frete nulo).
- Impacto: Pode ocorrer um comportamento não esperado no sistema, há a dificuldade de depuração e também potencial para corrupção de dados.

Baixa Coesão
- Problema: A classe Pedido possui métodos com responsabilidades não relacionadas:

a. Cálculo matemático (calcularFrete())

b. Formatação de strings (gerarEtiqueta())

c. Aplicação de descontos (aplicarFretePromocional())

d. Verificação de condições (isFreteGratis())

- Impacto: há a dificuldade de reutilização, e tem testabilidade comprometida, além de alto acoplamento.

Má Nomenclatura e Semântica Confusa
- Problemas Específicos:

a. aplicarFretePromocional() → Modifica o peso, não o frete

b. tipoFrete como String → Propenso a erros de digitação

c. destinatario e endereco sem validação/formatação

d. Métodos com nomes que não refletem seu comportamento real

Ausência de Abstrações e Extensibilidade
- Problema: Há uma estrutura if-else rígida para tipos de frete, tornando impossível adicionar novos tipos sem modificar código existente. Ou seja, há uma Violação do princípio Aberto-Fechado (OCP).
- Impacto: O Sistema torna-se muito resistente a mudanças por causa do alto acoplamento, aumentando o custo para adicionar novas funcionalidades, além de ser propenso a introdução de bugs.

> Código no Repositório para Questões 2. 3. e 4.

### Atividades Analíticas
1. 
A principal abstração realizada foi sobre o Calculo frete.
Substituição de If-Else por estratégias de calculo como no exemplo abaixo:

Problema Original (Código Legado)

```java
public double calcularFrete() {
    if (tipoFrete.equals("EXP")) {
        return peso * 1.5 + 10;
    } else if (tipoFrete.equals("PAD")) {
        return peso * 1.2;
    } else if (tipoFrete.equals("ECO")) {
        return peso * 1.1 - 5;
    } else {
        return 0;
    }
}
```

Trocado pelo [pacote de estratégia calculadora](/AT/appFrete/src/main/java/br/edu/infnet/appFrete/service/calculadora/)

Essa troca ajuda a manter o código mais testável uma vez que divide uma única função em vários módulos,
além de obedecer o principio Open/Closed do SOLID, onde essa estrutura permite uma expansibilidade do código sem alterar a função principal.

Além disso, fiz um [Enum](/AT/appFrete/src/main/java/br/edu/infnet/appFrete/model/TipoFrete.java) para formalizar o tipo de Frete e [Services](/AT/appFrete/src/main/java/br/edu/infnet/appFrete/service/) para lidar com a lógica de montagem de etiquetas e de calculo de frete.

2.
Eu adicionei validações no construtor da classe Entrega, que substitui o modelo central de atributos do pedido. A validação poderia ser feita em classes separadas para cada atributo.
Todavia utilizando-ás no construtor, foi possível mitigar uma serie de inconsistencias no sistema, como atributos nulos, ou peso negativo e zero.
Essa abordagem, simplifica o teste do comportamento das funcionalidades por impedir atributos inválidos ao contexto. Além de ter um feedback caso algum erro ocorra.

3.
Escolhi nome simples e coerentes para cada atributo e metodos, além de escolher nomes elucidativos sobre os métodos de tests.
Os nome são importantes porque eles devem dar uma boa intuição e sentido para outros programadores que entrem em contato, para ter uma manutenibilidade mais flúida e coerente.

```java
// Substantivos que representam conceitos do domínio
public class Entrega {}           // Entidade principal
public interface CalculadoraFrete {} // Comportamento/contrato
public enum TipoFrete {}          // Conjunto fixo de valores

// nomes descritivos que revelam intenção
private final double valorFrete; 

// Verbos que descrevem ações
public boolean isFreteGratis() {}         // Predicado/verificação

// Sufixos consistentes
public class EtiquetaService {}   // Serviço de aplicação
public class EntregaService {}    
```
> Outros Exemplos no código do Repositório

4.
Eu organizei de maneira a seguir o Single Responsability Principle, do solid, para separar em cada arquivo suas próprias intenções, 
além disso arranjei os arquivos em pacotes para reagrupar os arquivos similares.
> A Árvore está no repositorio.

5.
Dividir o projeto em camadas coesas, quase que independente da arquitetura do sistema, nos leva a ter maior facilidade cognitiva de lidar com o conteúdo do sistema.
Ter clareza e propósito é o que faz a diferença em uma manutenção de sistema. 
Além de reduzir drásticamente a necessidade de comentários que por muitas vezes só pioram o entendimento, seja pela má formulação ou pela carga cognitiva que ele traz.

### Testes

> Testes feitos com JUnit e JaCoCo. Relatarório de Cobertura em [HTML](/AT/appFrete/target/site/jacoco/).




