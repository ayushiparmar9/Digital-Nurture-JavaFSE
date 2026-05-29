// =========================
// JavaScript Basics
// =========================

console.log("Welcome to the Community Portal");

window.addEventListener("load", () => {
    alert("Community Portal Loaded Successfully");
});

// =========================
// Class & Objects
// =========================

class Event {

    constructor(name, category, date, seats) {

        this.name = name;
        this.category = category;
        this.date = date;
        this.seats = seats;
    }
}

// Prototype Method

Event.prototype.checkAvailability = function () {

    return this.seats > 0;
};

// =========================
// Data
// =========================

const events = [

    new Event(
        "Music Festival",
        "Music",
        "2026-06-10",
        20
    ),

    new Event(
        "Football Tournament",
        "Sports",
        "2026-06-15",
        15
    ),

    new Event(
        "Baking Workshop",
        "Workshop",
        "2026-06-20",
        10
    )

];

// Array push()

events.push(
    new Event(
        "Dance Competition",
        "Music",
        "2026-06-25",
        12
    )
);

// =========================
// Closure
// =========================

function createRegistrationCounter() {

    let count = 0;

    return function () {

        count++;

        console.log(
            `Total Registrations: ${count}`
        );

        return count;
    };
}

const registrationCounter =
    createRegistrationCounter();

// =========================
// DOM Elements
// =========================

const eventsContainer =
    document.querySelector("#eventsContainer");

const categoryFilter =
    document.querySelector("#categoryFilter");

const searchBox =
    document.querySelector("#searchBox");

// =========================
// Display Events
// =========================

function displayEvents(eventList = events) {

    eventsContainer.innerHTML = "";

    eventList.forEach(event => {

        if (!event.checkAvailability()) {
            return;
        }

        const card =
            document.createElement("div");

        card.classList.add("event-card");

        card.innerHTML = `

            <h3>${event.name}</h3>

            <p>
            Category:
            ${event.category}
            </p>

            <p>
            Date:
            ${event.date}
            </p>

            <p>
            Seats Left:
            ${event.seats}
            </p>

            <button
            onclick="registerUser('${event.name}')">

            Register

            </button>

        `;

        eventsContainer.appendChild(card);
    });
}

// =========================
// Register User
// =========================

function registerUser(eventName) {

    try {

        const event =
            events.find(
                e => e.name === eventName
            );

        if (!event) {

            throw new Error(
                "Event Not Found"
            );
        }

        if (event.seats <= 0) {

            throw new Error(
                "No Seats Available"
            );
        }

        event.seats--;

        registrationCounter();

        displayEvents();

    } catch (error) {

        alert(error.message);
    }
}

// =========================
// Filter Events
// =========================

function filterEventsByCategory(
    category,
    callback
) {

    const filtered =

        category === "All"

            ? [...events]

            : events.filter(
                e =>
                    e.category === category
            );

    callback(filtered);
}

categoryFilter.onchange = function () {

    filterEventsByCategory(
        this.value,
        displayEvents
    );
};

// =========================
// Search
// =========================

searchBox.addEventListener(
    "keydown",
    function () {

        const keyword =
            this.value.toLowerCase();

        const filtered =
            events.filter(

                event =>

                    event.name
                        .toLowerCase()
                        .includes(keyword)

            );

        displayEvents(filtered);
    }
);

// =========================
// Populate Dropdown
// =========================

const eventDropdown =
    document.querySelector(
        'select[name="event"]'
    );

events.forEach(event => {

    eventDropdown.innerHTML +=

        `<option>
            ${event.name}
        </option>`;
});

// =========================
// Form Handling
// =========================

document
    .querySelector("#registrationForm")
    .addEventListener(
        "submit",
        function (event) {

            event.preventDefault();

            const form =
                event.target;

            const name =
                form.elements.name.value;

            const email =
                form.elements.email.value;

            const selectedEvent =
                form.elements.event.value;

            const error =
                document.getElementById("error");

            const success =
                document.getElementById("success");

            error.innerText = "";
            success.innerText = "";

            if (
                !name ||
                !email ||
                !selectedEvent
            ) {

                error.innerText =
                    "All fields are required";

                return;
            }

            success.innerText =
                `Successfully Registered for ${selectedEvent}`;

            console.log(
                "Form Submitted Successfully"
            );
        }
    );

// =========================
// Object.entries()
// =========================

console.log(
    Object.entries(events[0])
);

// =========================
// map()
// =========================

const formattedNames =
    events.map(
        event =>
            `Workshop on ${event.name}`
    );

console.log(formattedNames);

// =========================
// Async / Promise
// =========================

function fetchEventsAsync() {

    document
        .getElementById("loader")
        .style.display = "block";

    return new Promise(resolve => {

        setTimeout(() => {

            resolve(events);

        }, 2000);
    });
}

document
    .getElementById("loadEvents")
    .onclick = async function () {

        const data =
            await fetchEventsAsync();

        console.log(data);

        document
            .getElementById("loader")
            .style.display = "none";
    };

// =========================
// Fetch API
// =========================

fetch(
    "https://jsonplaceholder.typicode.com/posts",
    {
        method: "POST",

        body: JSON.stringify({
            name: "Community User"
        }),

        headers: {
            "Content-Type":
                "application/json"
        }
    }
)
    .then(response =>
        response.json()
    )
    .then(data =>
        console.log(
            "POST Success:",
            data
        )
    )
    .catch(error =>
        console.log(error)
    );

// =========================
// jQuery
// =========================

$("#toggleCards").click(function () {

    $(".event-card").fadeToggle();
});

// =========================
// Initial Render
// =========================

displayEvents();