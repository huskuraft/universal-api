package dev.huskuraft.universal.vanilla.platform;

import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import com.google.auto.service.AutoService;

import dev.huskuraft.universal.api.core.ItemStack;
import dev.huskuraft.universal.api.input.KeyBinding;
import dev.huskuraft.universal.api.platform.ClientContentFactory;
import dev.huskuraft.universal.api.platform.SearchBy;
import dev.huskuraft.universal.api.platform.SearchTree;
import dev.huskuraft.universal.api.text.Text;
import dev.huskuraft.universal.vanilla.core.MinecraftItemStack;
import dev.huskuraft.universal.vanilla.input.MinecraftKeyBinding;
import net.minecraft.client.KeyMapping;
import net.minecraft.client.Minecraft;
import net.minecraft.client.searchtree.PlainTextSearchTree;
import net.minecraft.client.searchtree.SearchRegistry;
import net.minecraft.network.chat.Component;

@AutoService(ClientContentFactory.class)
public class MinecraftClientContentFactory extends MinecraftContentFactory implements ClientContentFactory {

    public static final MinecraftClientContentFactory INSTANCE = new MinecraftClientContentFactory();

    @Override
    public SearchTree<ItemStack> searchItemStack(SearchBy searchBy) {
        var minecraftSearchTree = Minecraft.getInstance().getSearchTree(
                switch (searchBy) {
                    case NAME -> SearchRegistry.CREATIVE_NAMES;
                    case TAG -> SearchRegistry.CREATIVE_TAGS;
                }
        );
        return query -> minecraftSearchTree.search(query).stream().map(itemStack -> new MinecraftItemStack(itemStack)).collect(Collectors.toList());
    }

    @Override
    public <T> SearchTree<T> search(List<T> list, Function<T, Stream<Text>> keyExtractor) {
        return query -> PlainTextSearchTree.create(list, item -> keyExtractor.apply(item).map(text -> ((Component) text.reference()).getString())).search(query);
    }

    @Override
    public KeyBinding newKeyBinding(String name, String category, int code) {
        return new MinecraftKeyBinding(new KeyMapping(name, code, category));
    }

}
