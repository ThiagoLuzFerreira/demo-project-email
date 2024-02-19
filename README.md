# demo-project-email

this microservice connects to a broker(rabbitMQ) and consumes messages to send a welcome email to new registred users.
it uses Java Mail Sender with Gmail SMTP to do it. so it saves the info used to send the email into a Mongo database.
it fetches data from a config server(https://github.com/ThiagoLuzFerreira/demo-project-config-server) that provides the credentials for Gmail SMTP service.
for mongoDB:

- install docker

- go to project root folder

- on terminal run: docker compose -f stack.yml up
