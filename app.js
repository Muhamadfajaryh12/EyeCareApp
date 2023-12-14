import dotenv from 'dotenv'
dotenv.config()
import express from 'express'
import cors from 'cors';
import connectDB from './config/connectdb.js'
import userRoutes from './routes/userRoutes.js'
import fileUpload from "express-fileupload"
import kacamataRoutes from './routes/kacamataRoutes.js'

const app = express()
const port = process.env.PORT
const DATABASE_URL = process.env.DATABASE_URL

// CORS Policy
app.use(cors())

// Database Connection
connectDB(DATABASE_URL)

// JSON
app.use(express.json())

//file simpan foto
app.use(fileUpload());
app.use(express.static("public"));

// Load Routes
app.use("/api/user", userRoutes)
app.use("/api/kacamata", kacamataRoutes)

app.listen(port, () => {
  console.log(`Server listening at http://localhost:${port}`)
})

