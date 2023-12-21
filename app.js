import dotenv from "dotenv";
dotenv.config();
import express from "express";
import cors from "cors";
import connectDB from "./config/connectdb.js";
import userRoutes from "./routes/userRoutes.js";

const app = express();
const port = process.env.PORT || 8080;
const DATABASE_URL = process.env.connectDB;

// CORS Policy
app.use(cors());

// Database Connection
connectDB(
  ""
);

// JSON
app.use(express.json());
app.use(express.urlencoded({ extended: true }));

app.listen(port, () => {
  console.log(`Server listening at http://localhost:${port}`);
});