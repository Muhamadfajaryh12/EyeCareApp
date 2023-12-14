import Kacamata from "../models/Kacamata.js";
import path from "path";
import fs from "fs";

export const getKacamatas = async(req, res)=> {
    try {
        const response = await Kacamata.findAll();
        res.json(response);
    } catch (error) {
        console.log(error.message);
    }
}

export const getKacamataById = async(req, res)=>{
    try {
        const response = await Kacamata.findOne({
            where: {
                id : req.params.id
            }
        })
        res.json(response);
    } catch (error) {
        console.log(error.message);
    }
}

export const saveKacamata = (req, res)=>{
    if(req.files === null) return res.status(400).json({msg: "No File Kacamata"});
    const name = req.body.title;
    const price = req.body.price;
    const category = req.body.category;
    const file = req.files.file;
    const fileSize = file.data.length;
    const ext = path.extname(file.name);
    const fileName = file.md5 + ext;
    const url = `${req.protocol}://${req.get("host")}/images/${fileName}`;
    const allowedType = ['.png','.jpg','.jpeg'];

    if(!allowedType.includes(ext.toLowerCase())) return res.status(422).json({msg: "Invalid Images"});
    if(fileSize > 5000000) return res.status(422).json({msg: "Image must be less than 5 MB"});

    file.mv(`./public/images/${fileName}`, async(err)=>{
        if(err) return res.status(500).json({msg: err.message});
        try {
            await Kacamata.create({name: name, price:price, category:category, image: fileName, url: url});
            res.status(201).json({msg: "Kacamata Created Successfuly"});
        } catch (error) {
            console.log(error.message);
        }
    })

}

export const updateKacamata = async(req, res)=>{
    const kacamata = await Kacamata.findOne({
        where:{
            id : req.params.id
        }
    });
    if(!kacamata) return res.status(404).json({msg: "No Data Found"});
    
    let fileName = "";
    if(req.files === null){
        fileName = kacamata.image;
    }else{
        const file = req.files.file;
        const fileSize = file.data.length;
        const ext = path.extname(file.name);
        fileName = file.md5 + ext;
        const allowedType = ['.png','.jpg','.jpeg'];

        if(!allowedType.includes(ext.toLowerCase())) return res.status(422).json({msg: "Invalid Images"});
        if(fileSize > 5000000) return res.status(422).json({msg: "Image must be less than 5 MB"});

        const filepath = `./public/images/${kacamata.image}`;
        fs.unlinkSync(filepath);

        file.mv(`./public/images/${fileName}`, (err)=>{
            if(err) return res.status(500).json({msg: err.message});
        });
    }
    const name = req.body.title;
    const price = req.body.price;
    const category = req.body.category;
    const url = `${req.protocol}://${req.get("host")}/images/${fileName}`;
    
    try {
        await Kacamata.update({name: name, price:price, category:category, image: fileName, url: url},{
            where:{
                id: req.params.id
            }
        });
        res.status(200).json({msg: "Kacamata Updated Successfuly"});
    } catch (error) {
        console.log(error.message);
    }
}

export const deleteKacamata = async(req, res)=>{
    const kacamata = await Kacamata.findOne({
        where:{
            id : req.params.id
        }
    });
    if(!kacamata) return res.status(404).json({msg: "No Data Found"});

    try {
        const filepath = `./public/images/${kacamata.image}`;
        fs.unlinkSync(filepath);
        await Kacamata.destroy({
            where:{
                id : req.params.id
            }
        });
        res.status(200).json({msg: "Kacamata Deleted Successfuly"});
    } catch (error) {
        console.log(error.message);
    }
}