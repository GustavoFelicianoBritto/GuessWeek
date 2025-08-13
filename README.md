# 🗓️ Calculadora de Dias do Calendário em Java

Este projeto é uma implementação em Java para calcular o dia da semana de qualquer data futura ou passada, bem como a diferença de dias entre duas datas.  
O principal diferencial é que toda a lógica de cálculo de datas e anos bissextos foi desenvolvida **do zero**, sem o uso de bibliotecas externas para as operações matemáticas de calendário.  
A única exceção é a utilização da API `java.time` para obter a data atual do sistema como ponto de partida.

---

## 🚀 Descrição do Projeto

O objetivo deste projeto é fornecer uma ferramenta robusta e precisa para:

- ✅ Verificar se um ano é bissexto.  
- 📅 Calcular o número de dias em um determinado mês.  
- 📆 Determinar quantos dias faltam para o fim de um ano a partir de uma data específica.  
- 🔄 Calcular a diferença exata de dias entre duas datas quaisquer (futuras ou passadas).  
- 📌 Descobrir o dia da semana de uma data alvo, partindo do dia da semana atual do sistema.

---

## ✨ Funcionalidades

- **Verificação de Ano Bissexto:** Identifica se um ano possui 366 dias.  
- **Contagem de Dias no Mês:** Retorna a quantidade correta de dias para cada mês, considerando anos bissextos.  
- **Dias Restantes no Ano:** Calcula quantos dias faltam de uma data específica até 31 de dezembro do mesmo ano.  
- **Diferença de Dias entre Datas:** Calcula o número de dias entre a data atual e uma data alvo.  
- **Previsão do Dia da Semana:** Informa qual dia da semana cairá em uma data futura ou passada.

---

## 🛠️ Tecnologias Utilizadas

- **Java** — Linguagem de programação principal.  
- **java.time API** — Utilizada exclusivamente para obter a data e o dia da semana atual do sistema (`LocalDate.now()`, `DayOfWeek`).  
  > Todos os cálculos de dias, meses e anos bissextos foram implementados manualmente.

---

## 💡 Lógica Central (Feito do Zero)

A complexidade deste projeto reside na implementação manual das regras do calendário.  
Diferente de usar métodos prontos, o código:

- Calcula anos bissextos com base nas regras de divisibilidade por **4, 100 e 400**.  
- Determina a quantidade de dias em cada mês, ajustando Fevereiro para anos bissextos.  
- Soma os dias de forma incremental, percorrendo meses e anos, para calcular a diferença entre duas datas (mesmo ano, anos futuros ou passados).  
- Utiliza a **aritmética modular (% 7)** para mapear o total de dias decorridos para o dia da semana correspondente, a partir de uma data de referência conhecida.

Este desafio foi uma oportunidade para aprofundar o entendimento de algoritmos de calendário e aprimorar habilidades de lógica e depuração.

---

## 🚀 Como Rodar o Projeto

### 📋 Pré-requisitos
- **JDK** (Java Development Kit) versão 8 ou superior instalado.

### 🔹 Compilação
No terminal, navegue até o diretório `src` do projeto e execute:

javac calendar/*.java


🔹 Execução
Após a compilação, vá para o diretório raiz do projeto (pai da pasta src) e execute:

bash
Copiar
Editar
java calendar.Main
Você pode modificar a data alvo na função main para testar diferentes cenários.

🚧 Status do Projeto e Próximos Passos
Status: ✅ Concluído para o cálculo principal.

Próximos Passos:

Criar uma interface web (Frontend em HTML/CSS/JS) para interagir com o código Java (Backend com Spring Boot).

Publicar a aplicação em um serviço de hospedagem em nuvem (como AWS).
