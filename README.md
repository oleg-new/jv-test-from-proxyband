# jv-test-from-proxyband
   This is a simple user management application.
   
   There is an api with 4 endpoints

"/users/add" - POST creates a new user

"/users/{id}" - PUT updates/changes user by id

"/users/" - GET lists all users

"/users/remove/{id}" - DELETE removes a user by id

the application is configured to work as a Docker image, first of all it needs to be compiled, to do this, in the root directory of the project, run the command

"mvn package"

then run the command

"docker compose up"

during execution, the Docker image "mongo_db" necessary for the operation of this application will be downloaded to your computer, then the image with the application itself will be built (only for the first time, the next time it will be used already built at the first start), and then both images will be launched for joint work

Use / test)))

===========================================================================================================

Это простое приложение для управления пользователями.
Имеется api с 4 эндпоинтами

"/users/add" - POST создает нового пользователя 

"/users/{id}"- PUT  обновляет/изменяет пользователя по ид

"/users/"  - GET  выдает список всех пользователей

"/users/remove/{id}"   - DELETE удаляет пользователя по ид

приложение настроено для работы в качестве Docker image, в первую очередь его недбходимо скомпилировать, для этого в коренном каталоге проекта выполните команду

" mvn  package"

затем выполните команду

"docker-compose up"

во время выполнения на Ваш компьютер будет сквчан Docker image "mongo_db", необходимый для работы данного приложения, затем собран image с самим приложением (только в первый раз, в последующие разы будет использован уже собраный при первом запуске), а затем запущены оба имейджа для совместной  работы

Пользуйтесь / тестируйте )))
