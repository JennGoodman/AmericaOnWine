export class InventoryItem {
    name: string;
    year: number;
    type: string;
    country: string;
    image: File;
    subType: string;

    constructor() {
        this.name = null;
        this.year = null;
        this.type = 'def';
        this.country = 'def';
        this.image = null;
        this.subType = 'def';
    }

    setVals(name: string, year: number, type: string, country: string, subType: string) {
        this.name = name;
        this.year = year;
        this.type = type;
        this.country = country;
        this.subType = subType;
        return this;
    }
}
