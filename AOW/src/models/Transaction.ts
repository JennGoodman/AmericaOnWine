export class Transaction {
    id: number;
    orderNumber: number;
    inventoryId: number;
    quantity: number;
    userId: number;
    total: number;
    rating: number;
    transactionDate: Date;
    comments: string;

    constructor() {
      this.id = null;
      this.orderNumber = null;
      this.inventoryId = null;
      this.quantity = null;
      this.userId = null;
      this.total = null;
      this.rating = null;
      this.transactionDate = null;
      this.comments = null;
    }
  }
