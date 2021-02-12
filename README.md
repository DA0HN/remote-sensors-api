# Remote Sensor API

Aplicação desenvolvida para servir de entreposto entre um aplicativo em Flutter e um microcontrolador Esp32. Para isso,
internamente utiliza uma fila para armazenar as informações geradas pelo microcontrolador. Ao final, esses dados serão
consumidos pelo aplicativo Flutter.

Ainda, para facilitar a integração entre o Esp32 e a ‘internet’ foi optado pelo deploy da API na nuvem utilizando os
serviços do Heroku.

* [Flutter](https://github.com/DA0HN/remote-sensors-app)
* [Esp32](https://github.com/DA0HN/remote-sensors-esp32)

## TODO

- [ ] Expandir os endpoints para mais sensores
- [ ] Adicionar endpoint para configurar a fila, coleta de dados do sensor, etc...
- [ ] Adicionar banco de dados não relacional (como MongoDB para aprendizagem)
- [ ] Dockerizar projeto

## Endpoints

| Descrição                              | URI                                   | Método |
|----------------------------------------|---------------------------------------|--------|
| Consulta a próxima temperatura da fila | /api/v1/remote-sensors/temperature    | GET    |
| Adiciona uma nova temperatura na fila  | /api/v1/remote-sensors/temperature    | POST   |