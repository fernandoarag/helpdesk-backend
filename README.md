
# Help Desk - API

Api desenvolvida para curso de JAVA Spring Boot + Angular;




## Documentação da API

### Retorna todos os Técnicos

```http
  GET /tecnicos
```
#### Header
| Parâmetro       | Tipo     | Descrição               | Obrigatório  |
| :-------------- | :------- | :---------------------- | :----------  |
| `Authorization` | `string` | Chave API(Bearer Token) |  ****`X`**** |

#### Body
| Parâmetro   | Tipo       | Descrição                                        | Obrigatório |
| :---------- | :--------- | :----------------------------------------------- | :---------- |
|    `none`   |   `none`   | ***Não é necessário envio de nenhum parâmetro*** |             |


### Retorna um Técnico pelo ID

```http
  GET /tecnicos/${id}
```

#### Header
| Parâmetro       | Tipo     | Descrição               | Obrigatório  |
| :-------------- | :------- | :---------------------- | :----------- |
| `Authorization` | `string` | Chave API(Bearer Token) |  ****`X`**** |

#### Body
| Parâmetro  | Tipo     | Descrição                             | Obrigatório  |
| :--------- | :------- | :------------------------------------ | :----------- |
| `id`       | `Number` | *ID do técnico ao qual deseja buscar* |  ****`X`**** |


### Deletar um técnico

```http
   DELETE /tecnicos/${id}
```

#### Header
| Parâmetro       | Tipo     | Descrição               | Obrigatório |
| :-------------- | :------- | :---------------------- | :---------- |
| `Authorization` | `string` | Chave API(Bearer Token) | ****`X`**** |

#### Body
| Parâmetro   | Tipo       | Descrição                                         | Obrigatório |
| :---------  | :--------- | :------------------------------------------------ | :---------- |
|    `none`   |   `none`   | ***Não é necessário envio de nenhum parâmetro***  |             |



### Criar/Atualiza um Técnico
***OBS.: Somente o Perfil 'ADMIN' pode realizar essas operações***

#### Criar Técnico:
```http
   POST /tecnicos
```

#### Atualizar Técnico:
```http
  PUT /tecnicos/${id}
```

#### Header
| Parâmetro       | Tipo     | Descrição               | Obrigatório |
| :-------------- | :------- | :---------------------- | :---------- |
| `Authorization` | `string` | Chave API(Bearer Token) | ****`X`**** |

#### Body
| Parâmetro  | Tipo       | Descrição                                         | Obrigatório |
| :--------- | :--------- | :------------------------------------------------ | :---------- |
| `nome`     | `String`   | *Nome do técnico*                                 | ****`X`**** |
| `cpf`      | `String`   | *CPF do técnico*                                  | ****`X`**** |
| `email`    | `String`   | *Email do técnico.* **Obs.: Utilizado no login.** | ****`X`**** |
| `senha`    | `String`   | *Senha do técnico.* **Obs.: Utilizado no login.** | ****`X`**** |
| `perfis`   | `Number[]` | *Código dos perfis ao qual deseja incluir.*       |             |

*****`OBS.: Todos os Técnicos criados já incluem o perfil 'CLIENTE' como PADRÃO.`*****
## Autores

- [@fernandoarag](https://www.github.com/fernandoarag)


## Stack utilizada

**Front-end:** Angular

**Back-end:** Java, Spring Boot, JWT Token

