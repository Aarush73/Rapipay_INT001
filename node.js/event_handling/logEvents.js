const date = require('date-fns')
const { v4 : uuid } = require('uuid')

const fs = require('fs')
const fsPromises = require('fs').promises
const path = require('path')

const logEvents = async (msg) => {
    const dateItem = date.format(new Date(), 'yyyy-MM-dd\tHH:mm:dd')
    const logItem = `${dateItem}\t${uuid()}\t${msg}\n`
    console.log(logItem)

    try {
        if(!fs.existsSync(path.join(__dirname, 'logs'))) {
            fsPromises.mkdir(path.join(__dirname, 'logs'))
        }
        await fsPromises.appendFile(path.join(__dirname, 'logs', 'logFile.txt'), logItem)
    } catch (error) {
        if (error) 
            console.error(error)
    }
}

module.exports = logEvents