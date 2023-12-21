import mongoose from "mongoose";
const uri =
  "";
const connectDB = async (uri) => {
  try {
    const DB_OPTIONS = {
      dbName: "EyeCare",
    };
    await mongoose.connect(uri, DB_OPTIONS);
    console.log("Connected Success");
  } catch (error) {
    console.log(error);
  }
};

export default connectDB;
