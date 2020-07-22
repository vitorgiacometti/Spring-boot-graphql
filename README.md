Exemplo de uso do graphql como uma abordagem 

##  About project



##### Query invoice by Id

```console
query {
 invoice(id:353)
  {
   price id customer price tax
  }
}
```
##### Query invoices

```console
query invoices{
  invoices{id customer price tax}
}
```
##### Mutation a invoice (same post invoice)

```console
mutation{ 
  updateInvoice(
    invoice:
        {id:353,
        customer:"Maria",
        price:"234",
        tax:"1244"}
    )    
    {customer,	
     id,
     price,
     tax
    }
}

```

##### Query Product 

```console
query {
 products
  {
   id name  value description 
  }
}
````

##### Mutation Product 

```console

mutation{ 
  createProduct(
    product:
        {
        name:"Chocolate Garoto",
        description:"200 Gramas",
        value:242}
    )    
    {
     name,	
     id,
     description,
     value
    }
}
````