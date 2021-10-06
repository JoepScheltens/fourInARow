package com.example.fourinarow

class Game {

    var currentColour = "black"
    var board: MutableList<MutableList<Circle>> = mutableListOf()

    fun setupBoard() {
        repeat(7){ column ->
            val row = mutableListOf<Circle>()
            repeat(6){ index ->
                row.add(Circle(column, index, "empty"))
            }
            board.add(row)
        }
    }

    private fun checkWin(circle : Circle) : Boolean {
        var count = 0

        val x = circle.x
        val y = circle.y
        val color = circle.color


        for(i in -3..3)
            if(x + i in 0..6){
                if(board[x + i][y].color == color){
                    count += 1
                } else {
                    count = 0
                }
                if(count == 4){
                    return true
                }
            }

        for(i in -3..3)
            if(y + i in 0..5){
                if(board[x][y + i].color == color){
                    count += 1
                } else {
                    count = 0
                }
                if(count == 4){
                    return true
                }
            }

        for(i in -3..3)
            if(x + i in 0..6 && y + i in 0..5){
                if(board[x + i][y + i].color == color){
                    count += 1
                } else {
                    count = 0
                }
                if(count == 4){
                    return true
                }
            }

        return false
    }

    private fun printBoard(){
        for(y in 0..5){
            for(x in 0..6){
                print("${board[x][5 - y].color} ")
            }
            println("")
        }
        println("")
    }

    fun addDisk(x : Int) {
        if(x in 1..7 && board[x][5].color == "empty"){

            var i = 0
            while(board[x][i].color != "empty"){
                i++
            }

            val circle = Circle(x, i, currentColour)

            board[x][i] = circle

            printBoard()
            if(checkWin(circle)){
                println("the winner is $currentColour")
            } else {
                println("no winner yet")
            }
            println("")
        }

        currentColour = if(currentColour == "black") {
            "(red)"
        } else {
            "black"
        }
    }
}