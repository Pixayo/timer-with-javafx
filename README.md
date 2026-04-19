
## Sobre
Um cronômetro simples, desenvolvido com o framework gráfico **JavaFX**.

A aplicação é minimalista e não salva histórico de forma persistente, porém, mantem um registro do último cronometro disparado em uma mesma sessão.

### Demonstração

https://github.com/user-attachments/assets/7fe3faaa-8891-4eb9-b46c-88dccf0aa7b8

<img width="677" height="327" alt="demo" src="https://github.com/user-attachments/assets/1718102f-a807-44ae-a51d-f3111369e976" />

### Como executar

Instale o arquivo `.jar` fornecido em `Releases` e certifique-se de que sua máquina possui um JRE (Java Runtime Environment).

Agora, em um terminal, vá até o diretório em que o arquivo `.jar` está localizado e execute:
```bash
java -jar Timer.jar
```

A aplicação deve aparecer em poucos segundos.

### Classes

Uma breve explicação de cada classe utilizada no projeto.

#### App.java

Onde é estruturada a interface da aplicação, assim como o controle dos botões.

#### Timer.java

Classe especializada, herda a classe abstrata `AnimationTimer` do pacote `javafx.animation`. Define toda a lógica do cronometro, tendo atributos internos que armazenam o estado atual (`running`) e a formatação do tempo em `strings`.

#### Launcher.java

Classe principal, ponto de entrada da aplicação. Necessária para a criação do executável `.jar`, pois o JavaFX não faz parte do JDK padrão desde o Java 9.

### Objetivo

Este projeto foi desenvolvido como um objeto de estudo do framework JavaFX e do gerenciamento de ciclos de vida de aplicações gráficas.

Dito isso, a aplicação não foi projetada para ser usada no cotidiano, mas se você procura por um app desktop simples e minimalista, este projeto pode o servir bem.

### Checklist

Ainda sinto que posso melhorar este projeto e, claro, estudar mais sobre a ferramenta com ele.

Estes são alguns dos objetivos que tenho para finalizar neste projeto:

- [ ] Mover a interface explícita em código para um arquivo `.fxml`.
- [ ] Adicionar um botão que reseta o cronômetro, assim como o registro anterior.
- [ ] Implementar atalhos de teclado para iniciar / parar o cronômetro.
- [ ] Desenvolver testes unitários.
- [ ] Empacotar a aplicação para que possa ser distribuída como executável.
- [ ] Criar menu de configuração contendo:
  - [ ] Switch para tema claro / escuro.
  - [ ] Permitir alterar a cor predominante (atual é laranja).
  - [ ] Permitir diferentes formatações de tempo.
  - [ ] Permitir diferentes atalhos de teclado.
