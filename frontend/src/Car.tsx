import React, { useState, useEffect } from "react";
import { SERVER_URL } from "./constant";
import CarForm from "./CarForm";
import DeleteComponent from "./DeleteComponent";
import EditComponent from "./EditComponent";

interface Car {
    id: number;
    brand: string;
    model: string;
    year: number
}

function CarComponent() {
    const [cars, setCars] = useState<Car[] | null>(null);

    const getCars = async () => {
        try {
            const response = await fetch(
                SERVER_URL + '/car',
                { method: 'GET', redirect: "follow", credentials: 'include' }
            );

            if (response.redirected) {
                document.location = response.url;
            }

            const data: Car[] = await response.json();
            setCars(data);
        } catch (error) {
            console.error("Error fetching cars:", error);
        }
    };

    function handleClick() {
        getCars();
    }

    useEffect(() => {
        getCars();
    }, []);

    return (
        <>
            <table>
                <thead>
                    <tr>
                        <th>Brand</th>
                        <th>Model</th>
                        <th>Year</th>
                    </tr>
                </thead>
                <tbody>
                    {Array.isArray(cars) && cars.map((car: Car) => (
                        <tr key={car.id}>
                            <td>{car.brand}</td>
                            <td>{car.model}</td>
                            <td>{car.year}</td>
                            <td><EditComponent car={car} handleClick={handleClick} /></td>
                            <td><DeleteComponent handleClick={handleClick} id={car.id} /></td>
                        </tr>
                    ))}
                </tbody>
            </table>
            <CarForm handleClick={handleClick} />
        </>
    );
}

export default CarComponent;
