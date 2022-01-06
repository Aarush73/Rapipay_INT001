const fs = require('fs')
const fsPromises = require('fs').promises
const path = require('path')

//readFile
// fs.readFile(path.join(__dirname, 'text_files', 'demo.txt'), 'utf-8', (err, data) => {
//   if (err) throw err;
//   console.log(data);
// });

// //Catching an UncaughtException
// process.on('uncaughtException', err => {
//     console.log("sorry for the error : "+err)
//     process.exit(1)
// })

console.log("First..")

// fs.writeFile(path.join(__dirname, 'text_files', 'newFile.txt'), 'My Name is Aarush', (err) => {
//     if (err) throw err;
//     console.log("Write Completed")

//     fs.appendFile(path.join(__dirname, 'text_files', 'newFile.txt'), '\n\ntgda bro', [], (err) => {
//         if (err) throw err
//         console.log("Append Complete")
           
//         fs.rename(path.join(__dirname, 'verynew.txt'), path.join(__dirname, 'text_files', 'newFile.txt'), (err) => {
//         if(err) throw err
//         console.log("Rename Completed")
//         })
//     })
// })

const fileOp = async () => {
    try {
        const data = await fsPromises.readFile(path.join(__dirname, 'text_files', 'newFile.txt'), {encoding: 'utf-8'})
        console.log(data)
        
        await fsPromises.unlink(path.join(__dirname, 'text_files', 'newFile.txt'))

        await fsPromises.writeFile(path.join(__dirname, 'text_files', 'latest.txt'), data)

        await fsPromises.appendFile(path.join(__dirname, 'text_files', 'latest.txt'), '\n\nNice My name is lalala')

        await fsPromises.rename(path.join(__dirname, 'text_files', 'latest.txt'), path.join(__dirname, 'text_files', 'latest1.txt'))
    
        const data1 = await fsPromises.readFile(path.join(__dirname, 'text_files', 'latest1.txt'), 'utf-8')
        console.log(data1)

    } catch (err) {
        console.error(err)
    }
}

//for large files stream is preferred as it is faster
const rs = fs.createReadStream(path.join(__dirname, 'text_files', 'latest1.txt'), {encoding : 'utf-8'})
const ws = fs.createWriteStream(path.join(__dirname, 'text_files', 'latest2.txt'))

// rs.on('data', (chunk) => {
//     ws.write(chunk);
// })

//or

rs.pipe(ws)

// fileOp()

// fs.mkdir('./new', (err) => {
//     if (err) throw err;
// })

// fs.rmdir('./new', (err) => {
//     if (err) throw err;
// })

