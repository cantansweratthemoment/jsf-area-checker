const canvas = document.getElementById('canvas');
document.addEventListener("DOMContentLoaded", function () {
    document.getElementById("canvas").addEventListener("click", (e) => {
        //let rr = document.getElementById("select");
        // let r = rr.value;
        let r = 2;//TODO это убрать
        let maslo = document.getElementById('canvas');
        let event_x = e.pageX - maslo.offsetLeft;
        let event_y = e.pageY - maslo.offsetTop;
        let x = (event_x-250) * r / 200;
        let y = (250-event_y) * r / 200;
        // post('controllerServlet', {X_f: x, Y_f: y, R_f: r});
        drawPoints();
        drawPoint(x, y, r, true);//TODO это тоже убрать
    })
});

function post(path, params, method = 'post') {
    const form = document.createElement('form');
    form.method = method;
    form.action = path;
    for (const key in params) {
        if (params.hasOwnProperty(key)) {
            const hiddenField = document.createElement('input');
            hiddenField.type = 'hidden';
            hiddenField.name = key;
            hiddenField.value = params[key];

            form.appendChild(hiddenField);
        }
    }
    document.body.appendChild(form);
    form.submit();
}

function drawCanvas() {
    let canvas = document.getElementById("canvas"),
        context = canvas.getContext("2d");
    canvas.width = 500;
    canvas.height = 500;
    context.fillStyle = "E8D7FF";
    context.fillRect(150, 250, 100, 200);
    context.beginPath();
    context.moveTo(250, 250);
    context.lineTo(450, 250);
    context.lineTo(250, 450);
    context.fill();
    context.moveTo(250, 250);
    context.arc(250, 250, 200, Math.PI, Math.PI * 3 / 2);
    context.fill();
    context.beginPath();
    context.strokeStyle = "#FF47A0";
    context.lineWidth = 2;
    context.moveTo(0, 250);
    context.lineTo(500, 250);
    context.stroke();
    context.beginPath();
    context.strokeStyle = "#FF47A0";
    context.lineWidth = 2;
    context.moveTo(250, 500);
    context.lineTo(250, 0);
    context.stroke();
    context.strokeText("R/2", 350, 250);
    context.strokeText("R", 450, 250);
    context.strokeText("R/2", 250, 350);
    context.strokeText("R", 250, 450);
    context.strokeText("R/2", 150, 250);
    context.strokeText("R/2", 250, 150);
    context.strokeText("R", 250, 50);
    context.strokeText("R/2", 350, 250);
    context.strokeText("R", 50, 250);
    context.strokeText("Y", 250, 10);
    context.strokeText("X", 490, 250);
    drawPoints();
}

function drawPoint(x, y, r, result) {
    let finalX=x / r * 400 / 2 + 250;
    let finalY=y / r * (-400) / 2 + 250;
    let canvas = document.getElementById("canvas"),
        context = canvas.getContext("2d");
    if (result === "false") {
        context.fillStyle = "#FF2A1F";
    } else {
        context.fillStyle = "#5FFF33";
    }
    context.beginPath();
    context.arc(finalX, finalY, 5, 0, 2 * Math.PI);
    context.fill();
    context.stroke();
    context.closePath();
}

function drawPoints() {//TODO ну перерисовка от радиуса все дела
    let coordinates = Array.prototype.slice.call(document.getElementById("resultTable").getElementsByTagName("td"));
    for (let i = 0; i < coordinates.length; i = i + 4) {
        drawPoint(Number(coordinates[i].innerHTML),
            Number(coordinates[i + 1].innerHTML),
            Number(coordinates[i + 2].innerHTML), coordinates[i + 3].innerHTML);
    }
}