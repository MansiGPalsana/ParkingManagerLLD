
Rough flow: 
 user comes to entry gate (can be 2 wheeler, four wheeler, large vehicle etc),
 entry time and vehicle number for user are noted on the ticket
 also alloted the parking spot from available spots (based on some algo like nearest or preference etc),
 user parks vehicle -> spot is marked as booked
 user leaves through exit gate - spot is marked available - fee is calculated and paid (based on time/ vehicle type etc)

-----------------------------------

Vehicle 
    +vehicleNumber: string
    +vehicleType: VehicleType
    +ticket: Ticket

-----------------------------------

VehicleType (enum)
    +TWO_WHEELER
    +FOUR_WHEELER

-----------------------------------

ParkingManager
    +parkingLevels: List<ParkingLevel>
    +parkingStrategy: ParkingStrategy
    +feeChargingStrategy: FeeChargingStrategy
    +entryGate: List<EntryGate>
    +exitgate: List<ExitGate>

    addGate()
    removeGate()
    addLevel()
    removeLevel()

    
    vehicleArrives(EntryGate e, Vehicle v)
    vehicleLeaves(ExitGate e, Vehicle v)

-----------------------------------

ParkingStrategy
    +findParkingSpot()

-----------------------------------


NearestParkingStrategy implements ParkingStrategy
    +findParkingSpot()

-----------------------------------

FurthestParkingStrategy implements ParkingStrategy
    +findParkingSpot()

-----------------------------------

ParkingLevel
    spots: List<ParkingSpot>
    addSpot()
    removeSpot()

-----------------------------------

ParkingSpot
    +id: int
    +status: SpotStatus
    +vehicle: Vehicle

-----------------------------------

SpotStatus
    +AVAILABLE
    +FILLED
    +UNDER_MAINTAINENCE

-----------------------------------

EntryGate
    +gateId: int
    +gateStatus: GateStatus
    findSpot()
    generateTicket()

-----------------------------------

ExitGate
    +gateId: int
    +gateStatus: GateStatus
    calculateFee()
    unmarkSpot()

-----------------------------------
GateStatus
    +OPEN
    +CLOSE
    +UNDER_MAINTAINENCE

-----------------------------------

Ticket
    +ticketNumber: int
    +vehicle: Vehicle
    +entryTime: Time

-----------------------------------

FeeChargingStrategy

___________________________________

Design patterns used: 

Singleton Pattern - Parking Manager is a singleton class

Strategy - pluggable strategies for finding parking spot, and calculating fee.



