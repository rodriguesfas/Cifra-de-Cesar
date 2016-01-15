# Encriptador de mensagens baseado na cifra de César – Criptografia Monoalfabética

Tem sua origem do grego: Kryptos = escondido Gráphein = escrita
Desenvolvida com o intuito de possibilitar à dois indivíduos se comunicar de forma segura, ou seja, 
consiste em cifrar uma informação que será enviada pelo remetente de forma que, caso esta informação 
seja interceptada por algum intruso, ele não seja capaz de entende-la.

# Código de César
Conta a história que Júlio César utilizava um código nas mensagens enviadas a seus generais, um sistema 
simples de substituição, no qual cada letra da mensagem original era trocada pela letra que se situa três
posições à sua frente. 

Ficando da seguinte forma: Cada letra “A” era substituída pela Letra “D”, “B” por “E” e assim sucessivamente. Qualquer 
código que tenha esse padrão é considerado um código de César. O alfabéto possui 26 letras, dessa forma pode-se cifrar 
o texto de 26 formas diferente

# Vejamos um Exemplo:

Texto original: clube dos geeks  Texto cifrado: foxeh#grv#jhhnv

Obs. “#” representa o espaço quando substituído.

Podemos reparar que a letra “c” será sempre substituída pela letra “f”, assim como a letra “e” sempre pela letra “h”, 
ou seja à um padrão.

# Decifrando:
Imaginando que essa mensagem foi interceptada, para decifra seria utilizado o método de força bruta, escrever repetidas
vezes a palavra deslocando uma letra de cada vez.

# Vejamos:

Deslocamento                    Mensagem
      0                     foxeh#grv#jhhnv

      1                     enwdg#fqu#iggmu

      2                     dmvcf#ept#hfflt

      3                     clube dos geeks

Mas os inimigos de César eram analfabetos! Assim ficou conhecido como o código de César “O cara que contribuiu para TI”. 

# Cifra Monoalfabética
É uma melhoria do código de César, ao invés de trocar as letras seguindo um padrão de deslocamento fixo, troca qualquer 
letra por qualquer outra. Dessa forma existe 26! combinações “permutações de 26 letras” possíveis. Inviabiliza força bruta “manual”.

# Decifrando
Para decifrar teria que utilizar técnicas mais avançadas, uma delas é a análise da linguagem.

#Aplicativo Java
![DMPHL298N Logo](https://github.com/rodriguesfas/Cifra-de-Cesar/blob/master/CifraDeCesar/img/cifra%20de%20cesar.png)
