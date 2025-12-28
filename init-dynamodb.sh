#!/bin/bash
echo "Aguardando LocalStack inicializar..."
sleep 10

echo "Criando tabela feedback..."
awslocal dynamodb create-table \
    --table-name feedback \
    --attribute-definitions AttributeName=id,AttributeType=S \
    --key-schema AttributeName=id,KeyType=HASH \
    --billing-mode PAY_PER_REQUEST \
    --region us-east-1

echo "Tabela feedback criada com sucesso!"