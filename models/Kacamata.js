import { Sequelize } from "sequelize";
import mongoose from "mongoose";

const {DataTypes} = Sequelize;

const kacamataSchema = new mongoose.Schema({
    name: {type: String, required: true, trim:true},
    price: {type: String, required: true, trim:true}, 
    image: {type: String, required: true, trim:true}, 
    category: {type: String, required: true, trim:true}, 
    url: {type: String, required: true, trim:true}
}) 

    const KacamataModel = mongoose.model("kacamata", kacamataSchema)

    export default KacamataModel