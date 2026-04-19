## Sobre
Um cronômetro simples, desenvolvido com o framework gráfico **JavaFX**.

A aplicação é minimalista e não salva histórico de forma persistênte, porém, mantem um registro do último cronometro disparado em uma mesma sessão.

### Demonstração

### Classes

Uma breve explicação de cada classe utilizada no projeto.

#### App.java

Onde é estruturado a interface da aplicação, assim como o controle dos botões.

#### Timer.java

Classe especializada, herda a classe abstrata `AnimationTimer` do pacote `javafx.animation`. Define toda a lógica do cronometro, tendo atributos internos que armazenam o estado atual (`running`) e a formatação do tempo em `strings`.

#### Launcher.java

Classe principal, ponto de entrada da aplicação. Necessária para a criação do executável `.jar`, pois o JavaFX não faz parte do JDK padrão desde o Java 9.

### Objetivo

Este projeto foi desenvolvido como um objeto de estudo do framework JavaFX e do gerenciamento de ciclos de vida de aplicações gráficas.

Dito isso, a aplicação não foi projetada para ser usada no cotidiano, mas se você procura por um app desktop simples e minimalista, este projeto pode o servir bem.

