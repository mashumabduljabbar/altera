# Task: Introduction No SQL & Mongo DB 
## Problem 1 : Create, Read, Update and Delete

### Prepare :

a. Create Database
```console
> use digital_outlet
switched to db digital_outlet
```

b. Create User
```console
> db.createUser( { user: "jabbar", pwd: "******", roles: [ { role: "dbAdmin", db: "digital_outlet" } ] } )
Successfully added user: {
        "user" : "jabbar",
        "roles" : [
                {
                        "role" : "dbAdmin",
                        "db" : "digital_outlet"
                }
        ]
}
```

c. Login menggunakan User
```console
root@MSI:/# mongo -u jabbar -p ****** 127.0.0.1:27017/digital_outlet
MongoDB shell version v4.0.28
connecting to: mongodb://127.0.0.1:27017/digital_outlet?gssapiServiceName=mongodb
Implicit session: session { "id" : UUID("3b7b4da8-17f1-4b3a-b115-fec050197a49") }
MongoDB server version: 6.0.0
WARNING: shell and server versions do not match
Server has startup warnings:
{"t":{"$date":"2022-07-26T05:40:24.133+07:00"},"s":"W",  "c":"CONTROL",  "id":22120,   "ctx":"initandlisten","msg":"Access control is not enabled for the database. Read and write access to data and configuration is unrestricted","tags":["startupWarnings"]}
```


### Create
#### a. insert 5 operators pada table operators
```console
> db.createCollection("operators")
{ "ok" : 1 }

> db.operators.insertMany( [
... { name: "Telkomsel" },
... { name: "Indosat" },
... { name: "Tri" },
... { name: "Axis" },
... { name: "XL" }
... ]  )
BulkWriteResult({
        "writeErrors" : [ ],
        "writeConcernErrors" : [ ],
        "ninsertManyed" : 5,
        "nUpserted" : 0,
        "nMatched" : 0,
        "nModified" : 0,
        "nRemoved" : 0,
        "upserted" : [ ]
})
```

#### b. insert 3 product type
```console
> db.createCollection("product_types")
{ "ok" : 1 }

> db.product_types.insertMany( [
... { name: "Kartu Perdana" },
... { name: "Pulsa" },
... { name: "Paket Data" }
... ]  )
BulkWriteResult({
        "writeErrors" : [ ],
        "writeConcernErrors" : [ ],
        "ninsertManyed" : 3,
        "nUpserted" : 0,
        "nMatched" : 0,
        "nModified" : 0,
        "nRemoved" : 0,
        "upserted" : [ ]
})
```

#### c. insert 2 product dengan product type id = 1, dan operators id = 3
```console
> db.createCollection("products")
{ "ok" : 1 }

> db.products.insertMany( [
... { id: 1, product_type_id: 1, operator_id: 3, code: "PRDN001", name: "Perdana Tri 100.000" },
... { id: 2, product_type_id: 1, operator_id: 3, code: "PRDN002", name: "Perdana Tri 200.000" }
... ] )
BulkWriteResult({
        "writeErrors" : [ ],
        "writeConcernErrors" : [ ],
        "ninsertManyed" : 2,
        "nUpserted" : 0,
        "nMatched" : 0,
        "nModified" : 0,
        "nRemoved" : 0,
        "upserted" : [ ]
})
```

#### d. insert 3 product dengan product type id = 2, dan operators id = 1
```console
> db.products.insertMany( [
... { id: 3, product_type_id: 2, operator_id: 1, code: "PLSTLK005", name: "Pulsa Telkomsel 5.000" },
... { id: 4, product_type_id: 2, operator_id: 1, code: "PLSTLK010", name: "Pulsa Telkomsel 10.000" },
... { id: 5, product_type_id: 2, operator_id: 1, code: "PLSTLK020", name: "Pulsa Telkomsel 20.000" }
... ] )
BulkWriteResult({
        "writeErrors" : [ ],
        "writeConcernErrors" : [ ],
        "ninsertManyed" : 3,
        "nUpserted" : 0,
        "nMatched" : 0,
        "nModified" : 0,
        "nRemoved" : 0,
        "upserted" : [ ]
})
```

#### e. insert 3 product dengan product type id = 3, dan operators id = 4
```console
> db.products.insertMany( [
... { id: 6, product_type_id: 3, operator_id: 4, code: "INETAX1GB", name: "Paket Internet Axis 1GB" },
... { id: 7, product_type_id: 3, operator_id: 4, code: "INETAX2GB", name: "Paket Internet Axis 2GB" },
... { id: 8, product_type_id: 3, operator_id: 4, code: "INETAX4GB", name: "Paket Internet Axis 4GB" }
... ] )
BulkWriteResult({
        "writeErrors" : [ ],
        "writeConcernErrors" : [ ],
        "ninsertManyed" : 3,
        "nUpserted" : 0,
        "nMatched" : 0,
        "nModified" : 0,
        "nRemoved" : 0,
        "upserted" : [ ]
})
```

#### f. insert product description pada setiap product
```console
> db.createCollection("product_description")
{ "ok" : 1 }

> db.product_description.insertMany( [
... { id: 1, product_id: 1, description: "Masa Berlaku 1 Hari" },
... { id: 2, product_id: 2, description: "Masa Berlaku 3 Hari" },
... { id: 3, product_id: 3, description: "Masa Berlaku 5 Hari" },
... { id: 4, product_id: 4, description: "Masa Berlaku 10 Hari" },
... { id: 5, product_id: 5, description: "Masa Berlaku 15 Hari" },
... { id: 6, product_id: 6, description: "Masa Berlaku 24 Jam" },
... { id: 7, product_id: 7, description: "Masa Berlaku 24 Jam" },
... { id: 8, product_id: 8, description: "Masa Berlaku 24 Jam" }
... ] )
BulkWriteResult({
        "writeErrors" : [ ],
        "writeConcernErrors" : [ ],
        "ninsertManyed" : 8,
        "nUpserted" : 0,
        "nMatched" : 0,
        "nModified" : 0,
        "nRemoved" : 0,
        "upserted" : [ ]
})
```

#### g. insert 3 payment methods
```console
> db.createCollection("payment_methods")
{ "ok" : 1 }

> db.payment_methods.insertMany( [
... { id: 1, name: "Cash" },
... { id: 2, name: "QRIS" },
... { id: 3, name: "Virtual Account Mandiri" }
... ] )
BulkWriteResult({
        "writeErrors" : [ ],
        "writeConcernErrors" : [ ],
        "ninsertManyed" : 3,
        "nUpserted" : 0,
        "nMatched" : 0,
        "nModified" : 0,
        "nRemoved" : 0,
        "upserted" : [ ]
})
```


#### h. insert 5 user pada table user
```console
> db.createCollection("users")
{ "ok" : 1 }

> db.users.insertMany( [
... { id: 1, name: "Fajar", address: "Jakarta", dob: "1993-07-28", status: 1, "gender": "M" },
... { id: 2, name: "Sawitry", address: "Jakarta", dob: "1995-07-24", status: 1, "gender": "F"  },
... { id: 3, name: "Rizky", address: "Jakarta", dob: "1993-06-22", status: 1, "gender": "M"  },
... { id: 4, name: "Jabbar", address: "Jakarta", dob: "1993-02-21", status: 1, "gender": "M"  },
... { id: 5, name: "Siska", address: "Jakarta", dob: "1994-07-17", status: 1, "gender": "F"  }
... ] )
BulkWriteResult({
        "writeErrors" : [ ],
        "writeConcernErrors" : [ ],
        "ninsertManyed" : 5,
        "nUpserted" : 0,
        "nMatched" : 0,
        "nModified" : 0,
        "nRemoved" : 0,
        "upserted" : [ ]
})
```

#### i. insert 3 transaksi di masing-masing user.
```console
> db.createCollection("transactions")
{ "ok" : 1 }

> db.transactions.insertMany( [
... { id: 1, user_id: 1, payment_method_id: 1, total_qty: 0, total_price: 0, status: "Lunas"},
... { id: 2, user_id: 1, payment_method_id: 1, total_qty: 0, total_price: 0, status: "Lunas"},
... { id: 3, user_id: 1, payment_method_id: 2, total_qty: 0, total_price: 0, status: "Lunas"},
... { id: 4, user_id: 2, payment_method_id: 1, total_qty: 0, total_price: 0, status: "Lunas"},
... { id: 5, user_id: 2, payment_method_id: 1, total_qty: 0, total_price: 0, status: "Lunas"},
... { id: 6, user_id: 2, payment_method_id: 2, total_qty: 0, total_price: 0, status: "Lunas"},
... { id: 7, user_id: 3, payment_method_id: 1, total_qty: 0, total_price: 0, status: "Lunas"},
... { id: 8, user_id: 3, payment_method_id: 1, total_qty: 0, total_price: 0, status: "Lunas"},
... { id: 9, user_id: 3, payment_method_id: 2, total_qty: 0, total_price: 0, status: "Lunas"},
... { id: 10, user_id: 4, payment_method_id: 1, total_qty: 0, total_price: 0, status: "Lunas"},
... { id: 11, user_id: 4, payment_method_id: 1, total_qty: 0, total_price: 0, status: "Lunas"},
... { id: 12, user_id: 4, payment_method_id: 2, total_qty: 0, total_price: 0, status: "Lunas"},
... { id: 13, user_id: 5, payment_method_id: 1, total_qty: 0, total_price: 0, status: "Lunas"},
... { id: 14, user_id: 6, payment_method_id: 1, total_qty: 0, total_price: 0, status: "Lunas"},
... { id: 15, user_id: 7, payment_method_id: 2, total_qty: 0, total_price: 0, status: "Lunas"},
])
BulkWriteResult({
        "writeErrors" : [ ],
        "writeConcernErrors" : [ ],
        "ninsertManyed" : 15,
        "nUpserted" : 0,
        "nMatched" : 0,
        "nModified" : 0,
        "nRemoved" : 0,
        "upserted" : [ ]
})
```

#### j. insert 3 product di masing-masing transaksi.
```console
> db.createCollection("transaction_details")
{ "ok" : 1 }
> db.transaction_details.insertMany( [
... { transaction_id: "1", product_id: "1", status: "-", qty: 1, price: 10000},
... { transaction_id: "1", product_id: "2", status: "-", qty: 1, price: 20000},
... { transaction_id: "1", product_id: "3", status: "-", qty: 1, price: 30000},
... { transaction_id: "2", product_id: "1", status: "-", qty: 1, price: 10000},
... { transaction_id: "2", product_id: "2", status: "-", qty: 1, price: 20000},
... { transaction_id: "2", product_id: "3", status: "-", qty: 1, price: 30000},
... { transaction_id: "3", product_id: "1", status: "-", qty: 1, price: 10000},
... { transaction_id: "3", product_id: "2", status: "-", qty: 1, price: 20000},
... { transaction_id: "3", product_id: "3", status: "-", qty: 1, price: 30000},
... { transaction_id: "4", product_id: "1", status: "-", qty: 1, price: 10000},
... { transaction_id: "4", product_id: "2", status: "-", qty: 1, price: 20000},
... { transaction_id: "4", product_id: "3", status: "-", qty: 1, price: 30000},
... { transaction_id: "5", product_id: "1", status: "-", qty: 1, price: 10000},
... { transaction_id: "5", product_id: "2", status: "-", qty: 1, price: 20000},
... { transaction_id: "5", product_id: "3", status: "-", qty: 1, price: 30000},
... { transaction_id: "6", product_id: "1", status: "-", qty: 1, price: 10000},
... { transaction_id: "6", product_id: "2", status: "-", qty: 1, price: 20000},
... { transaction_id: "6", product_id: "3", status: "-", qty: 1, price: 30000},
... { transaction_id: "7", product_id: "1", status: "-", qty: 1, price: 10000},
... { transaction_id: "7", product_id: "2", status: "-", qty: 1, price: 20000},
... { transaction_id: "7", product_id: "3", status: "-", qty: 1, price: 30000},
... { transaction_id: "8", product_id: "1", status: "-", qty: 1, price: 10000},
... { transaction_id: "8", product_id: "2", status: "-", qty: 1, price: 20000},
... { transaction_id: "8", product_id: "3", status: "-", qty: 1, price: 30000},
... { transaction_id: "9", product_id: "1", status: "-", qty: 1, price: 10000},
... { transaction_id: "9", product_id: "2", status: "-", qty: 1, price: 20000},
... { transaction_id: "9", product_id: "3", status: "-", qty: 1, price: 30000},
... { transaction_id: "10", product_id: "1", status: "-", qty: 1, price: 10000},
... { transaction_id: "10", product_id: "2", status: "-", qty: 1, price: 20000},
... { transaction_id: "10", product_id: "3", status: "-", qty: 1, price: 30000},
... { transaction_id: "11", product_id: "1", status: "-", qty: 1, price: 10000},
... { transaction_id: "11", product_id: "2", status: "-", qty: 1, price: 20000},
... { transaction_id: "11", product_id: "3", status: "-", qty: 1, price: 30000},
... { transaction_id: "12", product_id: "1", status: "-", qty: 1, price: 10000},
... { transaction_id: "12", product_id: "2", status: "-", qty: 1, price: 20000},
... { transaction_id: "12", product_id: "3", status: "-", qty: 1, price: 30000},
... { transaction_id: "13", product_id: "1", status: "-", qty: 1, price: 10000},
... { transaction_id: "13", product_id: "2", status: "-", qty: 1, price: 20000},
... { transaction_id: "13", product_id: "3", status: "-", qty: 1, price: 30000},
... { transaction_id: "14", product_id: "1", status: "-", qty: 1, price: 10000},
... { transaction_id: "14", product_id: "2", status: "-", qty: 1, price: 20000},
... { transaction_id: "14", product_id: "3", status: "-", qty: 1, price: 30000},
... { transaction_id: "15", product_id: "1", status: "-", qty: 1, price: 10000},
... { transaction_id: "15", product_id: "2", status: "-", qty: 1, price: 20000},
... { transaction_id: "15", product_id: "3", status: "-", qty: 1, price: 30000}
... ])
BulkWriteResult({
        "writeErrors" : [ ],
        "writeConcernErrors" : [ ],
        "ninsertManyed" : 45,
        "nUpserted" : 0,
        "nMatched" : 0,
        "nModified" : 0,
        "nRemoved" : 0,
        "upserted" : [ ]
})
```


### Read
#### a. Tampilkan nama user dengan gender Laki-Laki / M
```console
> db.users.find({gender: "M"})
{ "_id" : ObjectId("62dfc6e22798d62970d001f6"), "id" : 1, "name" : "Fajar", "address" : "Jakarta", "dob" : "1993-07-28", "status" : 1, "gender" : "M" }
{ "_id" : ObjectId("62dfc6e22798d62970d001f8"), "id" : 3, "name" : "Rizky", "address" : "Jakarta", "dob" : "1993-06-22", "status" : 1, "gender" : "M" }
{ "_id" : ObjectId("62dfc6e22798d62970d001f9"), "id" : 4, "name" : "Jabbar", "address" : "Jakarta", "dob" : "1993-02-21", "status" : 1, "gender" : "M" }
```

#### b. Tampilkan product dengan id = 3
```console
> db.products.find({id: 3})
{ "_id" : ObjectId("62dfbb5b2798d62970d001e5"), "id" : 3, "product_type_id" : 2, "operator_id" : 1, "code" : "PLSTLK005", "name" : "Pulsa Telkomsel 5.000" }
```

#### c. Hitung jumlah user dengan gender Perempuan / F
```console
> db.users.count({gender: "F"})
2
```

#### d. Tampilkan data user dengan urutan sesuai nama abjad
```console
> db.users.find().sort( { "name": 1 } )
{ "_id" : ObjectId("62dfc6e22798d62970d001f6"), "id" : 1, "name" : "Fajar", "address" : "Jakarta", "dob" : "1993-07-28", "status" : 1, "gender" : "M" }
{ "_id" : ObjectId("62dfc6e22798d62970d001f9"), "id" : 4, "name" : "Jabbar", "address" : "Jakarta", "dob" : "1993-02-21", "status" : 1, "gender" : "M" }
{ "_id" : ObjectId("62dfc6e22798d62970d001f8"), "id" : 3, "name" : "Rizky", "address" : "Jakarta", "dob" : "1993-06-22", "status" : 1, "gender" : "M" }
{ "_id" : ObjectId("62dfc6e22798d62970d001f7"), "id" : 2, "name" : "Sawitry", "address" : "Jakarta", "dob" : "1995-07-24", "status" : 1, "gender" : "F" }
{ "_id" : ObjectId("62dfc6e22798d62970d001fa"), "id" : 5, "name" : "Siska", "address" : "Jakarta", "dob" : "1994-07-17", "status" : 1, "gender" : "F" }
```

#### e. Tampilkan 5 data product
```console
> db.products.find().limit(5)
{ "_id" : ObjectId("62dfbb442798d62970d001e3"), "id" : 1, "product_type_id" : 1, "operator_id" : 3, "code" : "PRDN001", "name" : "Perdana Tri 100.000" }
{ "_id" : ObjectId("62dfbb442798d62970d001e4"), "id" : 2, "product_type_id" : 1, "operator_id" : 3, "code" : "PRDN002", "name" : "Perdana Tri 200.000" }
{ "_id" : ObjectId("62dfbb5b2798d62970d001e5"), "id" : 3, "product_type_id" : 2, "operator_id" : 1, "code" : "PLSTLK005", "name" : "Pulsa Telkomsel 5.000" }
{ "_id" : ObjectId("62dfbb5b2798d62970d001e6"), "id" : 4, "product_type_id" : 2, "operator_id" : 1, "code" : "PLSTLK010", "name" : "Pulsa Telkomsel 10.000" }
{ "_id" : ObjectId("62dfbb5b2798d62970d001e7"), "id" : 5, "product_type_id" : 2, "operator_id" : 1, "code" : "PLSTLK020", "name" : "Pulsa Telkomsel 20.000" }
```

### Update
#### a. Ubah data product id 1 dengan nama 'product dummy'
```console
> db.products.update({id: 1}, {"id" : 1, "product_type_id" : 1, "operator_id" : 3, "code" : "PRDN001", "name" : "product dummy"})
WriteResult({ "nMatched" : 1, "nUpserted" : 0, "nModified" : 1 })
```

#### b. Ubah qty = 3 pada transaction details dengan product id 1
```console
> db.transaction_details.update({product_id: "1"}, {$set: { "qty" : 3}}, {multi: true })
WriteResult({ "nMatched" : 15, "nUpserted" : 0, "nModified" : 14 })
```

### Delete
#### a. Delete data pada tabel product dengan id 1
```console
> db.products.remove({id: 1})
WriteResult({ "nRemoved" : 1 })
```

#### b. Delete pada data tabel product dengan product type id 1
```console
> db.products.remove({product_type_id: 1}, {multi: true })
WriteResult({ "nRemoved" : 3 })
```