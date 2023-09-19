# NPM manager
FROM node:16-alpine3.12

RUN npm install -g @vue/cli
COPY package*.json ./

# install project dependencies
RUN npm install

RUN mkdir /app
WORKDIR /app
COPY . /app

RUN npm install -g serve

CMD [ "npm", "run", "serve" ]