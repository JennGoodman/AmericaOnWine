export class InventoryItem {
    name: string;
    year: number;
    type: string;
    country: string;
    image: any;
    subType: string;

    constructor() {
        this.name = null;
        this.year = null;
        this.type = 'def';
        this.country = 'def';
        this.image = null;
        this.subType = 'def';
    }
}
