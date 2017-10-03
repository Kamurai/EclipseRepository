package snippet;

public class Snippet {
	SELECT CartRecords.Id, CartRecords.CartId, Items.Id, Items.Name, Items.QuantityAvailable, Items.Price, Items.Description, CartRecords.QuantityRequested
		INTO o_id, o_cartId, o_itemId, o_itemName, o_QuantityAvailable, o_Price, o_Description, o_QuantityRequested
		FROM CARTRECORDS
		JOIN ITEMS ON
		CartRecords.itemId = Items.Id
		WHERE CartRecords.id = i_id;
}

